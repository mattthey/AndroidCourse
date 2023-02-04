package filter

import SystemParameters
import push.AbstractPush

interface Filter {
    /**
     * @return true - если фильтр успешно пройден, false - если фильтр не пропускает данный пуш
     */
    fun filter(sysParams: SystemParameters, push: AbstractPush): Boolean
}