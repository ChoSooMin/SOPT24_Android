package org.sopt24.dshyun0226.androidseminar.Network.Get

import org.sopt24.dshyun0226.androidseminar.Data.ProductOverviewData

data class GetMainProductListResponse (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : ArrayList<ProductOverviewData>? // 데이터가 없을 수도 있기 때문에 ? 붙여줘야 한다.
)