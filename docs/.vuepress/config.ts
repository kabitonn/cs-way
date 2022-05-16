import { defineUserConfig } from "vuepress";
import { docsearchPlugin } from "@vuepress/plugin-docsearch";
import theme from "./theme";
import plugins from "./plugins";

export default defineUserConfig({
  lang: "zh-CN",
  title: "CS Way",
  description: "CS Way",

  base: "/cs-way/",

  head: [
    [
      "link",
      {
        rel: "stylesheet",
        href: "//at.alicdn.com/t/font_2410206_mfj6e1vbwo.css",
      },
    ],
  ],

  theme,
  plugins: plugins,
  markdown: {
    anchor: { level: [1, 2, 3, 4] },
    extractHeaders: { level: [1, 2, 3, 4] },
    extractTitle: null,
    code: { lineNumbers: 10 },
  }

});
