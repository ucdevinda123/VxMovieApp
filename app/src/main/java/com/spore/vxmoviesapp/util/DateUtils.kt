package com.spore.vxmoviesapp.util

class DateUtils {
    companion object{
        fun formatFilmDuration(runtime:Int) : String{
            val hours = runtime / 60
            val minutes = runtime % 60
            return "$hours h $minutes m"
        }
    }
}