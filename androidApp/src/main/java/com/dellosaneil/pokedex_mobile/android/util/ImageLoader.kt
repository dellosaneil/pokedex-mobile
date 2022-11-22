package com.dellosaneil.pokedex_mobile.android.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.disk.DiskCache

private const val IMAGE_CACHE = "image_cache"

@Composable
fun defaultImageLoader(context: Context): ImageLoader {
    return remember {
        ImageLoader.Builder(context)
            .components {
                add(SvgDecoder.Factory())
            }.diskCache {
                DiskCache.Builder()
                    .directory(context.cacheDir.resolve(relative = IMAGE_CACHE))
                    .build()
            }
            .build()
    }
}
