package filter

import SystemParameters
import push.AbstractPush
import push.HasExpiryDate

/**
 * Фильтрация по дате протухания пуша. Применяется для LocationPush, AgeSpecificPush.
 * Правило: если expiry_date у пуша строго меньше, чем time в системе, то пуш должен быть отфильтрован.
 */
class FilterByExpiryDate: Filter {
    override fun filter(sysParams: SystemParameters, push: AbstractPush): Boolean {
        if (push !is HasExpiryDate) return true

        return push.expiryDate >= sysParams.time
    }
}