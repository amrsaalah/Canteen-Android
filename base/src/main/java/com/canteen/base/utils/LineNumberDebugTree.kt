package com.canteen.base.utils

import timber.log.Timber

/**
 * Created by Amr Salah on 6/1/2019.
 */
class LineNumberDebugTree : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement): String? {
        return "timber(${element.fileName}:${element.lineNumber})#${element.methodName}"
    }

}