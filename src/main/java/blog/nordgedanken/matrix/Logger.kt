package blog.nordgedanken.matrix

import org.apache.logging.log4j.Level
import org.apache.logging.log4j.Marker
import org.apache.logging.log4j.MarkerManager

object Logger {
    val MOD_MARKER = MarkerManager.getMarker(Call.MOD_ID)

    private var logger: org.apache.logging.log4j.Logger? = null

    fun log(level: Level, format: String, vararg data: Any) {
        logger!!.printf(level, format, *data)
    }

    fun log(level: Level, throwable: Throwable, format: String, vararg data: Any) {
        if (logger!!.isEnabled(level)) {
            logger!!.log(level, String.format(format, *data), throwable)
        }
    }

    fun log(level: Level, marker: Marker, format: String, vararg data: Any) {
        logger!!.printf(level, marker, format, *data)
    }

    fun log(level: Level, marker: Marker, throwable: Throwable, format: String, vararg data: Any) {
        if (logger!!.isEnabled(level, marker)) {
            logger!!.log(level, marker, String.format(format, *data), throwable)
        }
    }

    fun fatal(format: String, vararg data: Any) {
        log(Level.FATAL, format, *data)
    }

    fun fatal(marker: Marker, format: String, vararg data: Any) {
        log(Level.FATAL, marker, format, *data)
    }

    fun fatal(throwable: Throwable, format: String, vararg data: Any) {
        log(Level.FATAL, throwable, format, *data)
    }

    fun fatal(marker: Marker, throwable: Throwable, format: String, vararg data: Any) {
        log(Level.FATAL, marker, throwable, format, *data)
    }

    fun error(format: String, vararg data: Any) {
        log(Level.ERROR, format, *data)
    }

    fun error(marker: Marker, format: String, vararg data: Any) {
        log(Level.ERROR, marker, format, *data)
    }

    fun error(throwable: Throwable, format: String, vararg data: Any) {
        log(Level.ERROR, throwable, format, *data)
    }

    fun error(marker: Marker, throwable: Throwable, format: String, vararg data: Any) {
        log(Level.ERROR, marker, throwable, format, *data)
    }

    fun warn(format: String, vararg data: Any) {
        log(Level.WARN, format, *data)
    }

    fun warn(marker: Marker, format: String, vararg data: Any) {
        log(Level.WARN, marker, format, *data)
    }

    fun info(format: String, vararg data: Any) {
        log(Level.INFO, format, *data)
    }

    fun info(marker: Marker, format: String, vararg data: Any) {
        log(Level.INFO, marker, format, *data)
    }

    fun info(throwable: Throwable, format: String, vararg data: Any) {
        log(Level.INFO, throwable, format, *data)
    }

    fun info(marker: Marker, throwable: Throwable, format: String, vararg data: Any) {
        log(Level.INFO, marker, throwable, format, *data)
    }

    fun debug(format: String, vararg data: Any) {
        log(Level.DEBUG, format, *data)
    }

    fun debug(marker: Marker, format: String, vararg data: Any) {
        log(Level.DEBUG, marker, format, *data)
    }

    fun debug(marker: Marker, throwable: Throwable, format: String, vararg data: Any) {
        log(Level.DEBUG, marker, throwable, format, *data)
    }

    fun setLogger(logger: org.apache.logging.log4j.Logger) {
        if (Logger.logger != null) {
            throw IllegalStateException("Attempt to replace logger")
        }

        Logger.logger = logger
    }


}