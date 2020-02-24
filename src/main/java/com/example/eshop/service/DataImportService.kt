package com.example.eshop.service

import org.springframework.stereotype.Service
import java.io.File

@Service
class DataImportService {

    fun csvToList(file: File): Set<Map<String, String>> {
        val data = mutableSetOf<Map<String, String>>()
        val header = mutableListOf<String>()
        file.readLines().forEach {
            when (header.isEmpty()) {
                true -> {
                    it.split(",").forEach {
                        header.add(it)
                    }
                }
                else -> {
                    val map = mutableMapOf<String, String>()
                    var i = 0
                    it.split("\",\"").forEach {
                        map[header.get(i)] = it.trim('"')
                        i++
                    }
                    data.add(map)
                }
            }
        }
        return data
    }
}