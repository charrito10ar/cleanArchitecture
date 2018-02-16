package com.nicequest.nicequesttest.domain.mappers

interface MapperInterface<in TFrom, out TTo> {
    fun map(from: TFrom): TTo
}