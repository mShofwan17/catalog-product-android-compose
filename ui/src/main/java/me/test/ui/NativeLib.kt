package me.test.ui

class NativeLib {

    /**
     * A native method that is implemented by the 'ui' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'ui' library on application startup.
        init {
            System.loadLibrary("ui")
        }
    }
}