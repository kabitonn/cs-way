import { navbar } from "vuepress-theme-hope";

export default navbar([
  "/",
  {
    text: "计算机基础", icon: "creative", prefix: "/notes/",
    children: [
      {
        text: "数据库",
        link: "数据库"
      },
      {
        text: "操作系统",
        link: "操作系统"
      },
      {
        text: "网络",
        link: "网络"
      }
    ]
  },
  {
    text: "软件工程", icon: "creative", prefix: "/notes/",
    children: [
      {
        text: "算法",
        link: "算法"
      }, {
        text: "系统设计",
        link: "系统设计"
      }, {
        text: "OOP",
        link: "OOP"
      }, {
        text: "工程质量",
        link: "工程质量"
      },
    ]
  },
  {
    text: "研发", prefix: "/notes/",
    children: [
      {
        text: "java",
        link: "Java"
      }, {
        text: "框架",
        link: "框架"
      }, {
        text: "中间件",
        link: "分布式中间件"
      }, {
        text: "前端",
        link: "前端"
      }
    ]
  },
  { text: "工具软件", icon: "creative", link: "/notes/工具/" },
  {
    text: "主题文档",
    icon: "note",
    link: "https://vuepress-theme-hope.github.io/v2/zh/",
  },

]);
