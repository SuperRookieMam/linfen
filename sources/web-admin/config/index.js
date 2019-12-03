'use strict'
// Template version: 1.3.1
// see http://vuejs-templates.github.io/webpack for documentation.

const path = require('path')

const assetsPublicPath = '/dc/'

module.exports = {
  assetsPublicPath,
  dev: {
    mode: 'development',
    useSso: false, // 是否启用oauth单点登录
    // Paths
    assetsSubDirectory: 'static', // 静态资源的路径
    assetsPublicPath, // 项目发布路径

    proxyTable: {
      // 如果使用本地后台服务，请打开下列配置
      //数据中心
      '/dc/d/root/': {
        changeOrigin: true,
        target: 'http://10.10.1.101:8082/',
        pathRewrite: { '^/dc/d/root/': '' }
      },
      // 数据中心
      '/dc/d/data/': {
        changeOrigin: true,
        target: 'http://127.0.0.1:8081/',
        pathRewrite: { '^/dc/d/data/': '' }
      },
      // 应急事件
      '/dc/d/emergency/': {
        changeOrigin: true,
        target: 'http://10.10.1.101:8082/',
        pathRewrite: { '^/dc/d/emergency/': '' }
      },
      //指标管理
      '/dc/d/kpi/': {
        changeOrigin: true,
        target: 'http://10.10.1.101:8084/',
        pathRewrite: { '^/dc/d/kpi/': '' }
      },
      //指标管理
      '/dc/d/app/': {
        changeOrigin: true,
        target: 'http://127.0.0.1:8089/',
        pathRewrite: { '^/dc/d/app/': '' }
      },
      // 应急指挥
      '/dc/d/ioc/': {
        changeOrigin: true,
        target: 'http://127.0.0.1:8083/',
        pathRewrite: { '^/dc/d/ioc/': '' }
      },
      '/dc/d/gather/': {
        changeOrigin: true,
        target: 'http://127.0.0.1:8084/',
        pathRewrite: { '^/dc/d/gather/': '' }
      },
      // 数据相关地址
      '/dc/d/': {
        changeOrigin: true,
        target: 'http://127.0.0.1:7080',
        // pathRewrite: { '^/dc/': '' }
      },
      // 用户管理相关地址
      '/dc/u/': {
        changeOrigin: true,
        target: 'http://10.10.1.101:8880',
        pathRewrite: { '^/dc/': '' }
      },
      // 权限管理相关地址
      '/dc/p/': {
        hangeOrigin: true,
        target: 'http://10.10.1.101:8880',
        pathRewrite: { '^/dc/p/': '' }
      },
      // 认证的地址，单独填写
      '/oauth/': {
        changeOrigin: true,
        // target: 'http://101.200.59.182',
        target: 'http://10.10.1.101:8887',
        hostRewrite: 'localhost:8888'
      }
    }, // devServer反向代理列表
    // Various Dev Server settings
    host: '0.0.0.0', // can be overwritten by process.env.HOST
    port: 8888, // 服务端口
    autoOpenBrowser: false, // 编译完成后是否自动打开浏览器
    errorOverlay: true, // 在devServer中，是否启用错误输出层
    notifyOnErrors: false, // 是否在系统通知区域提示错误
    poll: false, // https://webpack.js.org/configuration/dev-server/#devserver-watchoptions-

    // 是否使用 Eslint Loader 在编译过程中检查书写错误?
    // 格式错误会在控制台显示出来
    useEslint: true, //
    // 是否在devServer中用一个单独的层显示格式错误
    showEslintErrorsInOverlay: true,

    /**
     * Source Maps
     */

    // https://webpack.js.org/configuration/devtool/#development
    devtool: 'eval-source-map',

    // If you have problems debugging vue-files in devtools,
    // set this to false - it *may* help
    // https://vue-loader.vuejs.org/en/options.html#cachebusting
    cacheBusting: true,

    cssSourceMap: true
  },
  build: {
    mode: 'production',
    useSso: true, // 是否启用oauth单点登录
    // Template for index.html
    index: path.resolve(__dirname, '../dist/index.html'),

    // Paths
    assetsRoot: path.resolve(__dirname, '../dist'),
    assetsSubDirectory: 'static', // 静态资源的路径
    assetsPublicPath, // 项目的的发布路径，必须以'/'结尾,建议使用 '/CONTEXT_PATH'的模式

    /**
     * Source Maps
     */

    productionSourceMap: true,
    // https://webpack.js.org/configuration/devtool/#production
    devtool: 'source-map',

    // Gzip off by default as many popular static hosts such as
    // Surge or Netlify already gzip all static assets for you.
    // Before setting to `true`, make sure to:
    // npm install --save-dev compression-webpack-plugin
    productionGzip: false, // 是否启用Gzip压缩，如果使用nginx发布，必须选择false
    productionGzipExtensions: ['js', 'css'],

    // Run the build command with an extra argument to
    // View the bundle analyzer report.js after build finishes:
    // `npm run build --report.js`
    // Set to `true` or `false` to always turn it on or off
    bundleAnalyzerReport: process.env.npm_config_report
  }
}
