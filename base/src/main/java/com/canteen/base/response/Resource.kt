package com.canteen.base.response

/**
 * Created by Amr Salah on 11/26/2018.
 */
data class Resource<T>(
    val status: Status,
    val data: T? = null,
    val error: ErrorResponse? = null,
    val message: String? = null
) {

    companion object {
        fun <ResultType> success(data: ResultType): Resource<ResultType> =
            Resource(Status.SUCCESS, data)

        fun <ResultType> loading(): Resource<ResultType> = Resource(Status.LOADING)


        fun <ResultType> error(
            error: ErrorResponse? = null,
            message: String? = null
        ): Resource<ResultType> =
            Resource(Status.ERROR, error = error, message = message)

    }

}
