package com.example.testtaskansoft.core

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.testtaskansoft.R


fun Fragment.createLauncher(block: () -> Unit) =
    registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { map ->
        if (map.values.isNotEmpty() && map.values.all { it })
            block()
    }

fun Fragment.checkPermissions(
    launcher: ActivityResultLauncher<Array<String>>,
    block: () -> Unit,
) {
    if (REQUIRED_PERMISSIONS.all { permission ->
            ContextCompat.checkSelfPermission(
                requireContext(),
                permission
            ) == PackageManager.PERMISSION_GRANTED
        }) block()
    else launcher.launch(REQUIRED_PERMISSIONS)
}

val REQUIRED_PERMISSIONS = arrayOf(
    Manifest.permission.ACCESS_COARSE_LOCATION,
    Manifest.permission.ACCESS_FINE_LOCATION
)

fun Fragment.showError(
    action: () -> Unit
) {
    val dialogView = LayoutInflater.from(requireContext())
        .inflate(R.layout.dialog_error_internet, null, false)
    val repeatButton: Button = dialogView.findViewById(R.id.repeat_button)

    val dialog = AlertDialog.Builder(requireContext())
        .setView(dialogView)
        .create()

    repeatButton.setOnClickListener {
        action()
        dialog.dismiss()
    }
    dialog.show()
}