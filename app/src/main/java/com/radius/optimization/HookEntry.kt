package com.radius.optimization

import android.content.res.Resources
import android.util.DisplayMetrics
import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.configs
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.factory.method
import com.highcapable.yukihookapi.hook.log.YLog
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit

@InjectYukiHookWithXposed
object HookEntry : IYukiHookXposedInit {
    override fun onInit() = configs {
        isDebug = true
    }

    override fun onHook() = encase {
        loadApp("com.android.launcher") {
            "com.android.launcher3.util.SmoothRoundedProperties\$mTaskViewRadius16\$2".toClass().method {
                name = "invoke"
            }.hook {
                after {
                    val systemRes = Resources.getSystem()
                    val dmObj = systemRes.displayMetrics
                    val density = dmObj.density
                    val newRadius = 26f * density  // 自定义圆角 (dp * density)
                    result = newRadius
                }
            }.onAllFailure {
                it.localizedMessage?.let { message -> YLog.error(message) }
            }
        }
    }
}