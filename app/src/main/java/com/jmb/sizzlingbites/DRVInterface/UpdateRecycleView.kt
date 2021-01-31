package com.jmb.sizzlingbites.DRVInterface

import com.jmb.sizzlingbites.DynamicRvModel

/**
 * Created by jmerino on 1/30/21
 */
interface UpdateRecycleView {
    fun callBack(position:Int, list: List<DynamicRvModel>)
}