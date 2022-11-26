package com.dellosaneil.pokedex_mobile.android.util

import android.content.Context
import android.os.Build.VERSION.SDK_INT
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.decode.SvgDecoder
import coil.disk.DiskCache

private const val IMAGE_CACHE = "image_cache"

@Composable
fun defaultImageLoader(context: Context): ImageLoader {
    return remember {
        ImageLoader.Builder(context = context)
            .components {
                add(SvgDecoder.Factory())
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }.diskCache {
                DiskCache.Builder()
                    .directory(context.cacheDir.resolve(relative = IMAGE_CACHE))
                    .build()
            }
            .crossfade(enable = true)
            .crossfade(250)
            .build()
    }
}
