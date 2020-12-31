export default {
  /**
   * @description 配置显示在浏览器标签的title
   */
  title: '伞亮登场',
  /**
   * @description token在Cookie中存储的天数，默认1天
   */
  cookieExpires: 100,
  /**
   * @description 是否使用国际化，默认为false
   *              如果不使用，则需要在路由中给需要在菜单中展示的路由设置meta: {title: 'xxx'}
   *              用来在菜单中显示文字
   */
  useI18n: true,
  /**
   * @description api请求基础路径
   */
  baseUrl: {
    // dev: 'http://47.107.227.121:8088',
     dev: 'http://localhost:8088',
    pro: 'http://118.190.37.155:8088'
  },
  /**
   * @description 默认打开的首页的路由name值，默认为home
   */
  homeName: 'home',
  /**
   * @description 登录页面路径
   */
  login: 'login',


  /**
   * @description 需要加载的插件
   */
  plugin: {
    'error-store': {
      showInHeader: true, // 设为false后不会在顶部显示错误日志徽标
      developmentOff: true // 设为true后在开发环境不会收集错误信息，方便开发中排查错误
    }
  }
}
