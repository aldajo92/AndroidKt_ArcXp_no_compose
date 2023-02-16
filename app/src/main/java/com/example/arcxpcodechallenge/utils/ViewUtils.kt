package com.example.arcxpcodechallenge.utils

import com.google.android.material.floatingactionbutton.FloatingActionButton

fun FloatingActionButton.rotateFab() = this.animate()
    .scaleX(-1f)
    .setDuration(200)
    .withEndAction {
        this.animate()
            .scaleX(1f)
            .setDuration(200)
            .start()
    }
    .start()
