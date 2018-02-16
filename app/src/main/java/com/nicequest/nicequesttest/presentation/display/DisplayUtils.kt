package com.nicequest.nicequesttest.presentation.display


class DisplayUtils{

    companion object {
        private const val SMALL = 160
        private const val MEDIUM = 200
        private const val LARGE = 240
        private const val EXTRA_LARGE = 280

        fun getDpImageHeight(imageHeight: Int): Int {
            if (imageHeight <= 480) {
                return SMALL
            } else {
                if (imageHeight in 481..1440) {
                    return MEDIUM
                } else {
                    if (imageHeight in 1441..2220) {
                        return LARGE
                    }
                }
            }
            return EXTRA_LARGE
        }
    }
}