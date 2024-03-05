import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }

    fun printDeviceInfo() {
      println("Device name: $name, category: $category, type: $deviceType")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

    fun decreaseSpeakerVolume() {
      speakerVolume--
      println("Speaker volume decreased to $speakerVolume.")
    }

    fun previousChannel() {
      channelNumber--
      println("Channel number decreased to $channelNumber.")
    }

}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }

    fun decreaseBrightness() {
      brightnessLevel--
      println("Brightness decreased to $brightnessLevel.")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
      if(smartTvDevice.deviceStatus == "on") {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
      }
    }

    fun increaseTvVolume() {
      when(smartTvDevice.deviceStatus) {
        "on" -> smartTvDevice.increaseSpeakerVolume()
      }
    }

    fun decreaseTvVolume() {
      when(smartTvDevice.deviceStatus) {
        "on" -> smartTvDevice.decreaseSpeakerVolume()
      }
    }

    fun changeTvChannelToNext() {
      when(smartTvDevice.deviceStatus) {
        "on" -> smartTvDevice.nextChannel()
      }
    }

    fun changeTvChannelToPrevious() {
      when(smartTvDevice.deviceStatus) {
        "on" -> smartTvDevice.previousChannel()
      }
    }

    fun printSmartTvInfo() {
      smartTvDevice.printDeviceInfo()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
      if(smartLightDevice.deviceStatus == "on") {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
      }
    }

    fun increaseLightBrightness() {
      when(smartLightDevice.deviceStatus) {
        "on" -> smartLightDevice.increaseBrightness()
      }
    }

    fun decreaseLightBrightness() {
      when(smartLightDevice.deviceStatus) {
        "on" -> smartLightDevice.decreaseBrightness()
      }
    }

    fun printSmartLightInfo() {
      smartLightDevice.printDeviceInfo()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()
    smartDevice as SmartTvDevice
    smartDevice.increaseSpeakerVolume()
    smartDevice.decreaseSpeakerVolume()
    smartDevice.nextChannel()
    smartDevice.previousChannel()
    smartDevice.printDeviceInfo()
    smartDevice.turnOff()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
    smartDevice as SmartLightDevice
    smartDevice.increaseBrightness()
    smartDevice.decreaseBrightness()
    smartDevice.printDeviceInfo()
    smartDevice.turnOff()
}
