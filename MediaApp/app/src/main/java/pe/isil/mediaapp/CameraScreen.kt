package pe.isil.mediaapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import java.io.File

@Composable
fun CameraScreen() {
    val context = LocalContext.current
    val cameraPermission = Manifest.permission.CAMERA
    val lifeCycleOwner = LocalLifecycleOwner.current

    val imageCapture = remember {
        mutableStateOf<ImageCapture?>(null)
    }

    val hasPermission = remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context, cameraPermission)
                    == PackageManager.PERMISSION_GRANTED
        )
    }

    val permissionLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            hasPermission.value = isGranted
        }

    LaunchedEffect(true) {
        if (!hasPermission.value) {
            permissionLauncher.launch(cameraPermission)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (hasPermission.value) {
            AndroidView(
                modifier = Modifier,
                factory = { ctx ->
                    val previewView = PreviewView(ctx)
                    val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)

                    cameraProviderFuture.addListener({
                        val cameraProvider = cameraProviderFuture.get()
                        val preview = Preview.Builder().build().also {
                            it.surfaceProvider = previewView.surfaceProvider
                        }

                        imageCapture.value = ImageCapture.Builder().build()
                        val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

                        try {
                            cameraProvider.unbindAll()
                            cameraProvider.bindToLifecycle(
                                lifeCycleOwner,
                                cameraSelector,
                                preview,
                                imageCapture.value
                            )
                        } catch (exc: Exception) {
                            Log.e("Camera screen", "Use case binding failed", exc)
                        }
                    }, ContextCompat.getMainExecutor(ctx))
                    previewView

                })
            FloatingActionButton(
                modifier = Modifier.align(Alignment.BottomCenter),
                onClick = {
                    val file = createFile(context)
                    val outOptions = ImageCapture.OutputFileOptions.Builder(file).build()
                    imageCapture.value?.takePicture(
                        outOptions,
                        ContextCompat.getMainExecutor(context),
                        object : ImageCapture.OnImageSavedCallback {
                            override fun onError(exc: ImageCaptureException) {
                                Log.e("CameraScreen", "Photo capture failed: ${exc.message}", exc)
                            }

                            override fun
                                    onImageSaved(output: ImageCapture.OutputFileResults) {
                                val msg = "Photo capture succeeded: ${output.savedUri}"
                                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                                Log.d("CameraScreen", msg)
                            }
                        }
                    )
                }) {
                Icon(Icons.Default.Check, contentDescription = null)
            }

        } else {
            Text("Permission required")
        }
    }

}

fun createFile(context: Context): File {
    val directory = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File(directory, "IMG_${System.currentTimeMillis()}.jpg")
}