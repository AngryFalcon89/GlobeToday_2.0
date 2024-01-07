package com.example.newsapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.newsapp.data.model.SourceDTO

@ProvidedTypeConverter
class NewsTypeConvertor {

    @TypeConverter
    fun sourceToString(source: SourceDTO): String{
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(source: String): SourceDTO{
        return source.split(',').let { sourceArray ->
            SourceDTO(id = sourceArray[0], name = sourceArray[1])
        }
    }
}