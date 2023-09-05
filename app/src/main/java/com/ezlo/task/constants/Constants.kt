package com.ezlo.task.constants

import androidx.paging.PagingConfig

object Constants {

    /**
     *  Page size value of [androidx.paging.PagingConfig] for pagination
     */
    private const val PAGE_SIZE = 10

    val PAGING_CONFIG = PagingConfig(
        pageSize = PAGE_SIZE,
        prefetchDistance = PAGE_SIZE / 2,
        enablePlaceholders = false
    )

    /**
     *  Devices Platform
     */
    const val SERCOMM_G450 = "Sercomm G450"
    const val SERCOMM_G550 = "Sercomm G550"
    const val MICASAVERDE_VERALITE = "MiCasaVerde VeraLite"
    const val SERCOMM_NA900 = "Sercomm NA900"
    const val SERCOMM_NA301 = "Sercomm NA301"
    const val SERCOMM_NA930 = "Sercomm NA930"

    const val RESETDATA = "Reset data"
    const val EDITDATA = "Edit Data"

}