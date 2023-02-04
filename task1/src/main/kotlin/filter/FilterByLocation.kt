package filter

import SystemParameters
import push.AbstractPush
import push.HasLocation
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Фильтрация по положению. Применяется для пушей типа LocationPush, LocationAgePush.
 * Правило: если координаты системы по евклидову расстоянию x_coord, y_coord строго дальше от координат пуша
 * на radius из пуша, то пуш должен быть отфильтрован (т.е. не показан).
 */
class FilterByLocation: Filter {
    override fun filter(sysParams: SystemParameters, push: AbstractPush): Boolean {
        if (push !is HasLocation) return true

        val distance = sqrt((sysParams.coordX - push.xCoord).toDouble().pow(2.0)
                + (sysParams.coordY - push.yCoord).toDouble().pow(2.0))
        return distance <= push.radius
    }
}