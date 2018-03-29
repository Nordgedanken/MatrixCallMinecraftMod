package blog.nordgedanken.matrix.audio

import blog.nordgedanken.matrix.Logger
import javax.sound.sampled.AudioFormat
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.DataLine
import javax.sound.sampled.SourceDataLine
import javax.sound.sampled.TargetDataLine
import javax.sound.sampled.Mixer



object Magic {
    private fun getAudioFormat(): AudioFormat {
        val sampleRate = 44100.0f
        val sampleSizeInBits = 16
        val channels = 2
        val signed = true
        val bigEndian = true
        return AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian)
    }

    fun startMagic() {
        val mixerInfo = AudioSystem.getMixerInfo()    //get available mixers
        val audioFormat = getAudioFormat()     //get the audio format
        println("Available mixers:")
        var mixer: Mixer? = null
        var targetLine: TargetDataLine? = null
        var sourceLine: SourceDataLine? = null
        Logger.info("Indices: %s", mixerInfo.indices)
        for (cnt in mixerInfo.indices) {
            Logger.info(" " + mixerInfo[cnt].name)
            mixer = AudioSystem.getMixer(mixerInfo[cnt])

            val TlineInfos = mixer.targetLineInfo
            val SlineInfos = mixer.sourceLineInfo
            if (TlineInfos.isNotEmpty() && TlineInfos[0].lineClass == TargetDataLine::class.java) {
                //TODO check for device name the user decided to use. For now I use the primary
                if (targetLine != null) {
                    continue
                }
                val targetLineR = DataLine.Info(TlineInfos[0].lineClass, audioFormat)
                targetLine = mixer.getLine(targetLineR) as TargetDataLine
                Logger.info("Mic is supported!")
            }
            if (SlineInfos.isNotEmpty() && SlineInfos[0].lineClass == SourceDataLine::class.java) {
                //TODO check for device name the user decided to use. For now I use the primary
                if (sourceLine != null) {
                    continue
                }
                val sourceLineR = DataLine.Info(SlineInfos[0].lineClass, audioFormat)
                sourceLine = mixer.getLine(sourceLineR) as SourceDataLine
                Logger.info("Headphone is supported!")
            }
            if (sourceLine != null && targetLine != null) {
                break
            }
        }

        try {
            if (mixer != null) {
                if (targetLine != null){
                    targetLine.open(audioFormat)
                    targetLine.start()
                }

                if (sourceLine != null) {
                    sourceLine.open(audioFormat)
                    sourceLine.start()
                }

                var numBytesRead: Int? = null
                var targetData: ByteArray? = null
                if (targetLine != null){
                    targetData = ByteArray(targetLine.bufferSize / 5)
                }

                while (true) {
                    if (targetLine != null && targetData != null){
                        numBytesRead = targetLine.read(targetData, 0, targetData.size)
                    }

                    if (numBytesRead == -1) break

                    if (sourceLine != null && numBytesRead != null){
                        sourceLine.write(targetData, 0, numBytesRead)
                    }

                }
            }

        } catch (e: Exception) {
            Logger.error(e.message.toString())
        }

    }

}