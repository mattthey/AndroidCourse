package filter

import SystemParameters
import push.AbstractPush
import push.HasGender

/**
 * Фильтрация по полу. Применяется для пушей GenderAgePush, GenderPush.
 * Правило: если gender, указанный в системе, отличен от переданного в пуше, то пуш должен быть отфильтрован.
 */
class FilterByGender: Filter {
    override fun filter(sysParams: SystemParameters, push: AbstractPush): Boolean {
        if (push !is HasGender) return true

        return sysParams.gender == push.gender
    }
}