package camp.codelab.fragments.models

import com.google.gson.annotations.SerializedName

open class BaseSearchResponse(
        @SerializedName("request_hash")
        var requestHash: String = "", // request:search:27c14c264a514e16a400698fd3622304b3a7f99a
        @SerializedName("request_cached")
        var requestCached: Boolean = false, // true
        @SerializedName("request_cache_expiry")
        var requestCacheExpiry: Int = 0, // 40287
        @SerializedName("last_page")
        var lastPage: Int = 0 // 20
)
