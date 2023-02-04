package filter

import SystemParameters
import push.AbstractPush
import push.HasAge

/**
 * Фильтрация по возрасту. Применяется для пушей типа AgeSpecificPush, LocationAgePush, GenderAgePush.
 * Правило: если age, указанный в пуше, строго больше, чем age, заданный системе, то пуш должен быть отфильтрован.
 */
class FilterByAge: Filter {
    override fun filter(sysParams: SystemParameters, push: AbstractPush): Boolean {
        if (push !is HasAge) return true
        return push.age <= sysParams.age
    }
}