import { sidebar } from "vuepress-theme-hope";
import { database, network, os } from "./basic";
import { fe, framework, java, mw } from "./code";
import { software, softquality, oop, alg } from "./software";
import { tool } from "./tool";
export default sidebar({
    "/notes/数据库": database,
    "/notes/操作系统": os,
    "/notes/网络": network,

    "/notes/系统设计": software,
    "/notes/算法": alg,
    "/notes/OOP": oop,
    "/notes/工程质量": softquality,

    "/notes/Java": java,
    "/notes/前端": fe,
    "/notes/分布式中间件": mw,
    "/notes/框架": framework,

    "/notes/工具": tool,
    "/": ["home.md", "slide.md"],

})