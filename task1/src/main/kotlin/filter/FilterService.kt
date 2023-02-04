package filter

import SystemParameters
import push.AbstractPush

class FilterService {
    private val filters: List<Filter> = listOf(
        FilterByLocation(),
        FilterByAge(),
        FilterByOsVersion(),
        FilterByExpiryDate(),
        FilterByGender()
    )

    fun isCorrectPush(sysParams: SystemParameters, push: AbstractPush): Boolean =
        filters.all { it.filter(sysParams, push) }
}