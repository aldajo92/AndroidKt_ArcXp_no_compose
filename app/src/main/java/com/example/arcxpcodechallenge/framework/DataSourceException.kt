package com.example.arcxpcodechallenge.framework

sealed class DataSourceException(
    val messageResource: Any?
) : RuntimeException() {

    class Connection(messageResource: Any?) : DataSourceException(messageResource)

    class Unexpected(messageResource: Any?) : DataSourceException(messageResource)

    class Timeout(messageResource: Any?) : DataSourceException(messageResource)

    class Client(messageResource: Any?) : DataSourceException(messageResource)

    class Server(messageResource: Any?) : DataSourceException(messageResource)

    class DataBase(messageResource: Any?): DataSourceException(messageResource)
}
