package blog.nordgedanken.matrix.audio

import blog.nordgedanken.matrix.Logger
import javax.sound.sampled.AudioFormat
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.DataLine
import javax.sound.sampled.SourceDataLine
import javax.sound.sampled.TargetDataLine

object TestMic {
    fun startMagic() {
        val format = AudioFormat(44100f, 16, 2, true, true)

        val targetInfo = DataLine.Info(TargetDataLine::class.java, format)
        val sourceInfo = DataLine.Info(SourceDataLine::class.java, format)

        try {
            val targetLine = AudioSystem.getLine(targetInfo) as TargetDataLine
            targetLine.open(format)
            targetLine.start()

            val sourceLine = AudioSystem.getLine(sourceInfo) as SourceDataLine
            sourceLine.open(format)
            sourceLine.start()

            var numBytesRead: Int
            val targetData = ByteArray(targetLine.bufferSize / 5)

            while (true) {
                numBytesRead = targetLine.read(targetData, 0, targetData.size)

                if (numBytesRead == -1) break

                sourceLine.write(targetData, 0, numBytesRead)
            }
        } catch (e: Exception) {
            Logger.error(e.message.toString())
        }

    }

}