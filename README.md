# Oplus Launcher Radius Optimization

一个基于 YukiHookAPI 开发的 Xposed 模块，用于优化 ColorOS 系统桌面的最近任务卡片圆角效果。

## ✨ 功能特性

- 🎨 **自定义圆角半径** - 调整最近任务卡片的圆角大小
- 🎯 **精准目标** - 仅针对 ColorOS 系统桌面 (`com.android.launcher`)
- ⚡ **轻量高效** - 低资源占用，不影响系统性能
- 🔒 **安全稳定** - 不修改系统核心文件，可随时禁用

## 📋 兼容性

- **目标应用**: ColorOS 系统桌面 (`com.android.launcher`)
- **Android 版本**: Android 16/15 (ColorOS 16-15 / RealmeUI 7-6 / OxygenOS 16-15)
- **依赖框架**: LSPosed / 其他 Xposed 框架
- **API 版本**: YukiHookAPI 1.3.0

## 🔧 安装方法

### 前提条件
1. 已安装并激活 Xposed 框架 (推荐 LSPosed)
2. 确保目标应用为 ColorOS 系统桌面

### 安装步骤
1. 下载最新版本的 APK 文件
2. 安装到你的设备
3. 在 Xposed 管理器中启用本模块
4. 在模块作用域中勾选「系统桌面」
5. 重启设备或软重启系统桌面

## ⚙️ 配置说明

系统桌面最近任务卡片圆角初始值为`16dp`，模块更改圆角值为`26dp`，如需自定义圆角值，请在`/app/src/main/java/com/radius/optimization/HookEntry.kt`中的`第27行`进行更改


## 🛠️ 构建说明

### 环境要求
- Android SDK 30+
- Java 17

### 构建步骤
```bash
# 克隆项目
git clone https://github.com/Qjj7679/Oplus-Launcher-RadiusOptimization.git

# 构建并安装
./gradlew assembleDebug
