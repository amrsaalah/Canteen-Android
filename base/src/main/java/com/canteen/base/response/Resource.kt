package com.canteen.base.response

import androidx.annotation.NonNull
import androidx.annotation.Nullable

/**
 * Created by Amr Salah on 11/26/2018.
 */
data class Resource<T>(
    @NonNull val status: Status,
    @Nullable val data: T? = null,
    @Nullable val message: String? = null
) {

    companion object {
        fun <ResultType> success(data: ResultType): Resource<ResultType> =
            Resource(Status.SUCCESS, data)

        fun <ResultType> dbSuccess(data: ResultType): Resource<ResultType> =
            Resource(Status.SUCCESS, data, "DB")


        fun <ResultType> loading(): Resource<ResultType> = Resource(Status.LOADING)


        fun <ResultType> error(message: String?, data: ResultType? = null): Resource<ResultType> =
            Resource(Status.ERROR, message = message, data = data)

    }

}


data class PagingResource<T>(
    @NonNull val status: Status,
    @Nullable val data: T? = null,
    @NonNull val moreDataAvailable: Boolean = false,
    @Nullable val message: String? = null
) {

    companion object {
        fun <ResultType> success(data: ResultType): PagingResource<ResultType> = PagingResource(
            Status.SUCCESS, data
        )


        fun <ResultType> loading(): PagingResource<ResultType> = PagingResource(Status.LOADING)


        fun <ResultType> error(
            message: String?,
            data: ResultType? = null
        ): PagingResource<ResultType> =
            PagingResource(Status.ERROR, message = message, data = data)

    }

}