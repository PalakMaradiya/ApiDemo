package com.example.apicallappication.RESPONSE

import com.google.gson.annotations.SerializedName

data class SecondResopen(

	@field:SerializedName("SecondResopen")
	val secondResopen: List<SecondResopenItem?>? = null
)

data class SecondResopenItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("completed")
	val completed: Boolean? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)
