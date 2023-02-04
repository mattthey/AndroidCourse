package filter

import SystemParameters
import push.AbstractPush
import push.HasOsVersion

/**
 * Фильтрация по версии системы. Применяется для TechPush.
 * Правило: если os_version в системе строго больше, чем os_version в пуше, то пуш должен быть отфильтрован
 * (то есть, пуш показывается на равных и более старых версиях, чем указано в пуше).
 */
class FilterByOsVersion: Filter {
    override fun filter(sysParams: SystemParameters, push: AbstractPush): Boolean {
        if (push !is HasOsVersion) return true

        return sysParams.osVersion <= push.osVersion
    }
}