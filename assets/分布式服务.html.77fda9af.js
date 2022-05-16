import{_ as a}from"./plugin-vue_export-helper.21dcd24c.js";import{r as l,c as r,a as e,b as i,F as d,f as n,d as s,o}from"./app.2e0a550f.js";var h="/cs-way/assets/mk-2020-07-12-11-11-16.50c26c13.png",c="/cs-way/assets/mk-2020-07-12-11-11-54.a1cae1fa.png",p="/cs-way/assets/mk-2020-08-19-15-25-26.6a871dc4.png",f="/cs-way/assets/mk-2020-08-19-15-26-46.5d84ee07.png",g="/cs-way/assets/mk-2020-07-12-11-17-11.4fa67511.png",u="/cs-way/assets/mk-2020-08-17-16-49-26.55377549.png",m="/cs-way/assets/mk-2020-08-19-15-27-47.97f75cd9.png";const S={},x=n('<ul><li><a href="#%E4%BB%8B%E7%BB%8D">\u4ECB\u7ECD</a><ul><li><a href="#RPC">RPC</a></li><li><a href="#SOA">SOA</a></li></ul></li><li><a href="#%E6%A1%86%E6%9E%B6">\u6846\u67B6</a><ul><li><a href="#HSF">HSF</a><ul><li><a href="#%E5%8A%9F%E8%83%BD%E8%A7%92%E8%89%B2">\u529F\u80FD\u89D2\u8272</a></li><li><a href="#%E6%A8%A1%E5%9D%97">\u6A21\u5757</a></li><li><a href="#%E5%86%85%E9%83%A8%E6%A1%86%E6%9E%B6">\u5185\u90E8\u6846\u67B6</a></li><li><a href="#%E8%B0%83%E7%94%A8%E6%96%B9%E5%BC%8F">\u8C03\u7528\u65B9\u5F0F</a></li><li><a href="#%E8%B4%9F%E8%BD%BD%E4%BD%93%E7%B3%BB">\u8D1F\u8F7D\u4F53\u7CFB</a></li></ul></li><li><a href="#Dubbo">Dubbo</a></li></ul></li></ul><h1 id="\u4ECB\u7ECD" tabindex="-1"><a class="header-anchor" href="#\u4ECB\u7ECD" aria-hidden="true">#</a> \u4ECB\u7ECD</h1><p>\u4E00\u822C\u610F\u4E49\u4E0A\uFF0C\u4E00\u4E2A\u516C\u53F8\u7684\u4E1A\u52A1\u7CFB\u7EDF\u53D1\u5C55\u8109\u7EDC\u57FA\u672C\u90FD\u662F\u7C7B\u4F3C\uFF0C\u4ECE\u5355\u4F53\u5E94\u7528\u5230\u591A\u5E94\u7528\uFF0C\u4ECE\u672C\u5730\u8C03\u7528\u5230\u8FDC\u7A0B\u8C03\u7528\uFF0C\u968F\u7740\u53D1\u5C55\u9700\u8981\u5BF9\u8FDC\u7A0B\u670D\u52A1\u8FDB\u884C\u9AD8\u6548\u7684\u8D44\u6E90\u7BA1\u7406\uFF0C\u8FD9\u4E2A\u8FC7\u7A0B\u662F\u7CFB\u7EDF\u5E94\u5BF9\u53D8\u5316\u548C\u590D\u6742\u7684\u5E94\u5BF9\u4E4B\u9053\u3002</p><h2 id="rpc" tabindex="-1"><a class="header-anchor" href="#rpc" aria-hidden="true">#</a> RPC</h2><p>RPC\uFF08Remote Process Call\uFF09\uFF0C\u5373\u8FDC\u7A0B\u670D\u52A1\u8C03\u7528\uFF0C\u88AB\u5E7F\u6CDB\u5730\u5E94\u7528\u5728\u5F88\u591A\u4F01\u4E1A\u5E94\u7528\u4E2D\uFF0C\u662F\u65E9\u671F\u4E3B\u8981\u7684\u670D\u52A1\u6CBB\u7406\u65B9\u6848\uFF0C\u5176\u6D41\u7A0B\u8F83\u4E3A\u7B80\u5355\uFF0C\u5BA2\u6237\u7AEFconsumer\u643A\u5E26\u53C2\u6570\u53D1\u9001RPC\u8BF7\u6C42\u5230\u670D\u52A1\u63D0\u4F9B\u65B9provider\uFF0Cprovider\u6839\u636E\u53C2\u6570\u8DEF\u7531\u5230\u5177\u4F53\u51FD\u6570\uFF0C\u65B9\u6CD5\uFF0C\u5E76\u5C06\u6267\u884C\u83B7\u5F97\u7684\u7ED3\u679C\u8FD4\u56DE\uFF0C\u81F3\u6B64\u4E00\u6B21RPC\u8C03\u7528\u5B8C\u6210\u3002</p><p><img src="'+h+'" alt="" loading="lazy"></p><p>\u968F\u7740\u4E1A\u52A1\u7684\u53D1\u5C55\uFF0C\u5927\u6570\u636E\u65F6\u4EE3\u7684\u5230\u6765\uFF0C\u670D\u52A1\u63D0\u4F9B\u65B9\u7684\u538B\u529B\u4E5F\u65E5\u76CA\u589E\u5927\uFF0C\u5355\u673A\u5E94\u7528\u7684\u5904\u7406\u80FD\u529B\u65E0\u8BBA\u5728\u8F6F\u4EF6\uFF0C\u786C\u4EF6\u4E0A\u90FD\u53D7\u5230\u9650\u5236\uFF0Cprovider\u4E5F\u4E0D\u53EF\u80FD\u4E00\u76F4\u65E0\u9650\u6269\u5BB9\uFF0C\u5373\u4F7F\u6269\u5BB9\uFF0C\u4E5F\u5B58\u5728\u7740\u5F88\u591A\u95EE\u9898\uFF0C\u5373\u670D\u52A1\u7684\u8DEF\u7531\uFF0C\u548CConsumer\u7684\u8D1F\u8F7D\u5747\u8861\u95EE\u9898\u3002\u56E0\u6B64\uFF0C\u5206\u5E03\u5F0F\u670D\u52A1\u67B6\u6784\u5E94\u8FD0\u800C\u751F\uFF0CRPC\u53D1\u5C55\u5230\u4E00\u5B9A\u9636\u6BB5\u601D\u8003\u7684\u53D8\u9769\uFF0C\u6210\u4E3A\u4E86\u5206\u5E03\u5F0F\u670D\u52A1\uFF0C\u4E91\u8BA1\u7B97\u7684\u8BA1\u7B97\u673A\u57FA\u7840\u3002</p><h2 id="soa" tabindex="-1"><a class="header-anchor" href="#soa" aria-hidden="true">#</a> SOA</h2><p>\u7531\u4E8E\u7B80\u5355\u7684RPC\u8C03\u7528\u5DF2\u7ECF\u4E0D\u80FD\u968F\u7740\u65F6\u4EE3\u53D1\u5C55\u6EE1\u8DB3\u9700\u6C42\uFF0C\u56E0\u6B64\u590D\u6742\u7684\u4E1A\u52A1\u903B\u8F91\u5BF9\u4E8E\u5206\u5E03\u5F0F\u5E94\u7528\u67B6\u6784\u4F53\u7CFB\u7684\u9700\u6C42\u6108\u53D1\u5F3A\u70C8\uFF0C\u4E1A\u52A1\u5E0C\u671B\u81EA\u5DF1\u7684\u670D\u52A1\u662F\u5206\u5E03\u5F0F\u90E8\u7F72\u7684\uFF0C\u8BF7\u6C42\u662F\u5206\u6D41\u7684\uFF0C\u5BF9\u6570\u636E\u7684\u64CD\u4F5C\u662F\u80FD\u8BFB\u5199\u5206\u79BB\u7684\uFF0C\u540C\u65F6\u80FD\u5C4F\u853D\u8BB8\u591A\u590D\u6742\u9700\u8981\u81EA\u5DF1\u7F16\u5199\u7684\u5E95\u5C42\u670D\u52A1\uFF0C\u501F\u52A9\u5DF2\u6709\u7684\u516C\u5171\u670D\u52A1\uFF0C\u53BB\u5FEB\u901F\u7684\u6784\u5EFA\u81EA\u5DF1\u7684\u5E94\u7528\uFF0C\u964D\u4F4E\u4EBA\u529B\u5F00\u53D1\u7EF4\u62A4\u7684\u6210\u672C\u548C\u63D0\u9AD8\u5E94\u7528\u4EA4\u4ED8\u7684\u6548\u7387\uFF0C\u57FA\u56E0\u6B64\uFF0C\u57FA\u4E8E\u5206\u5E03\u5F0F\u670D\u52A1\u601D\u60F3\u7684SOA\uFF08Service-Oriented Architecture\uFF09\u6210\u4E86\u65B0\u7684\u53D7\u8FFD\u6367\u7684\u67B6\u6784\u3002\u5E38\u89C1\u7684SOA\u670D\u52A1\u8C03\u7528\u6D41\u7A0B\u56FE\u5982\u4E0B\uFF1A</p><p><img src="'+c+'" alt="" loading="lazy"></p><h1 id="\u6846\u67B6" tabindex="-1"><a class="header-anchor" href="#\u6846\u67B6" aria-hidden="true">#</a> \u6846\u67B6</h1><h2 id="hsf" tabindex="-1"><a class="header-anchor" href="#hsf" aria-hidden="true">#</a> HSF</h2><p>HSF (High-speed Service Framework)\uFF0C\u9AD8\u901F\u670D\u52A1\u6846\u67B6\uFF0C\u662F\u5728\u963F\u91CC\u5DF4\u5DF4\u5185\u90E8\u5E7F\u6CDB\u4F7F\u7528\u7684\u5206\u5E03\u5F0F RPC \u670D\u52A1\u6846\u67B6\u3002</p><h3 id="\u529F\u80FD\u89D2\u8272" tabindex="-1"><a class="header-anchor" href="#\u529F\u80FD\u89D2\u8272" aria-hidden="true">#</a> \u529F\u80FD\u89D2\u8272</h3><p>HSF\u529F\u80FD\u7ED3\u6784\u4E0A\u5206\u4E3A6\u4E2A\u90E8\u5206\uFF0C\u5206\u522B\u662F\uFF1A\u670D\u52A1\u6D88\u8D39\u65B9\u3001\u670D\u52A1\u63D0\u4F9B\u65B9\u3001\u5730\u5740\u6CE8\u518C\u4E2D\u5FC3\u3001\u6301\u4E45\u5316\u914D\u7F6E\u4E2D\u5FC3\u3001\u5143\u6570\u636E\u5B58\u50A8\u4E2D\u5FC3\u548CHSF\u8FD0\u7EF4\u5E73\u53F0\uFF08HSF \u63A7\u5236\u53F0\uFF09\uFF0C\u5B83\u4EEC\u7EC4\u5408\u5728\u4E00\u8D77\u53EF\u4EE5\u63D0\u4F9B\u5168\u529F\u80FD\u7684\u5206\u5E03\u5F0F\u670D\u52A1\uFF0C\u5176\u4E2D\u5FC5\u987B\u7684\u662F\u670D\u52A1\u6D88\u8D39\u65B9\u3001\u670D\u52A1\u63D0\u4F9B\u65B9\u548C\u5730\u5740\u6CE8\u518C\u4E2D\u5FC3\uFF0C\u4E0A\u8FF0\u529F\u80FD\u7ED3\u6784\u7684\u63CF\u8FF0\u5982\u4E0B\u8868\uFF1A</p><table><thead><tr><th style="text-align:left;">\u540D\u79F0</th><th style="text-align:center;">\u662F\u5426\u5FC5\u987B</th><th style="text-align:left;">\u529F\u80FD\u63CF\u8FF0</th></tr></thead><tbody><tr><td style="text-align:left;">\u670D\u52A1\u6D88\u8D39\u65B9</td><td style="text-align:center;">\u662F</td><td style="text-align:left;">\u6D88\u8D39\u670D\u52A1\u63D0\u4F9B\u65B9\u63D0\u4F9B\u7684\u670D\u52A1\uFF0C\u670D\u52A1\u6D88\u8D39\u8005\u901A\u8FC7\u5730\u5740\u6CE8\u518C\u4E2D\u5FC3\u8BA2\u9605\u670D\u52A1\uFF0C\u6839\u636E\u8BA2\u9605\u5230\u7684\u5730\u5740\u4FE1\u606F\u53D1\u8D77\u8C03\u7528\uFF0C\u5730\u5740\u6CE8\u518C\u4E2D\u5FC3\u4F5C\u4E3A\u65C1\u8DEF\u4E0D\u53C2\u4E0E\u8C03\u7528</td></tr><tr><td style="text-align:left;">\u670D\u52A1\u63D0\u4F9B\u65B9</td><td style="text-align:center;">\u662F</td><td style="text-align:left;">\u670D\u52A1\u63D0\u4F9B\u65B9\u4F1A\u7ED1\u5B9A\u4E00\u4E2A\u7AEF\u53E3\uFF08\u4E00\u822C\u662F12200\uFF09\uFF0C\u63A5\u53D7\u8BF7\u6C42\u5E76\u63D0\u4F9B\u670D\u52A1\uFF0C\u540C\u65F6\u5C06\u5730\u5740\u4FE1\u606F\u53D1\u5E03\u5230\u5730\u5740\u6CE8\u518C\u4E2D\u5FC3</td></tr><tr><td style="text-align:left;">\u5730\u5740\u6CE8\u518C\u4E2D\u5FC3</td><td style="text-align:center;">\u662F</td><td style="text-align:left;">\u63A5\u53D7\u670D\u52A1\u63D0\u4F9B\u65B9\u53D1\u5E03\u7684\u5730\u5740\uFF0C\u5F53\u670D\u52A1\u6D88\u8D39\u65B9\u6839\u636E\u670D\u52A1\u8FDB\u884C\u8BA2\u9605\u65F6\uFF0C\u4F1A\u5C06\u5730\u5740\u4FE1\u606F\u63A8\u9001\u7ED9\u670D\u52A1\u6D88\u8D39\u65B9\uFF0C\u6CE8\u518C\u4E2D\u5FC3\u5C31\u662F\u670D\u52A1\u4FE1\u606F\u7684\u4E2D\u4ECB\uFF0C\u63D0\u4F9B\u670D\u52A1\u53D1\u73B0\u7684\u80FD\u529B</td></tr><tr><td style="text-align:left;">\u6301\u4E45\u5316\u914D\u7F6E\u4E2D\u5FC3</td><td style="text-align:center;">\u5426</td><td style="text-align:left;">\u6301\u4E45\u5316\u7684\u914D\u7F6E\u4E2D\u5FC3\u7528\u4E8E\u5B58\u50A8 HSF \u670D\u52A1\u7684\u5404\u79CD\u6CBB\u7406\u89C4\u5219\uFF0CHSF \u5BA2\u6237\u7AEF\u5728\u542F\u52A8\u7684\u8FC7\u7A0B\u4E2D\u4F1A\u5411\u6301\u4E45\u5316\u914D\u7F6E\u4E2D\u5FC3\u8BA2\u9605\u5404\u79CD\u670D\u52A1\u6CBB\u7406\u89C4\u5219\uFF0C\u5982\u8DEF\u7531\u89C4\u5219\u3001\u5F52\u7EC4\u89C4\u5219\u3001\u6743\u91CD\u89C4\u5219\u7B49\uFF0C\u4ECE\u800C\u6839\u636E\u89C4\u5219\u5BF9\u8C03\u7528\u8FC7\u7A0B\u7684\u9009\u5740\u903B\u8F91\u8FDB\u884C\u5E72\u9884</td></tr><tr><td style="text-align:left;">\u5143\u6570\u636E\u5B58\u50A8\u4E2D\u5FC3</td><td style="text-align:center;">\u5426</td><td style="text-align:left;">\u5143\u6570\u636E\u662F\u6307 HSF \u670D\u52A1\u5BF9\u5E94\u7684\u65B9\u6CD5\u5217\u8868\u4EE5\u53CA\u53C2\u6570\u7ED3\u6784\u7B49\u4FE1\u606F\uFF0C\u5143\u6570\u636E\u4E0D\u4F1A\u5BF9 HSF \u7684\u8C03\u7528\u8FC7\u7A0B\u4EA7\u751F\u5F71\u54CD\uFF0C\u56E0\u6B64\u5143\u6570\u636E\u5B58\u50A8\u4E2D\u5FC3\u4E5F\u5E76\u4E0D\u662F\u5FC5\u987B\u7684\u3002\u4F46\u8003\u8651\u5230\u670D\u52A1\u8FD0\u7EF4\u7684\u4FBF\u6377\u6027\uFF0CHSF\u5BA2\u6237\u7AEF\u5728\u542F\u52A8\u65F6\u4F1A\u5C06\u5143\u6570\u636E\u4E0A\u62A5\u5230\u5143\u6570\u636E\u5B58\u50A8\u4E2D\u5FC3\uFF0C\u4EE5\u4FBF\u63D0\u4F9B\u7ED9\u670D\u52A1\u8FD0\u7EF4\u4F7F\u7528</td></tr><tr><td style="text-align:left;">HSF\u8FD0\u7EF4\u5E73\u53F0</td><td style="text-align:center;">\u5426</td><td style="text-align:left;">HSF \u63A7\u5236\u53F0\u901A\u8FC7\u6253\u901A\u5730\u5740\u6CE8\u518C\u4E2D\u5FC3 ConfigServer\u3001\u6301\u4E45\u5316\u914D\u7F6E\u4E2D\u5FC3 Diamond\u3001\u5143\u6570\u636E\u5B58\u50A8\u4E2D\u5FC3 Redis\uFF0C\u4E3A\u7528\u6237\u63D0\u4F9B\u4E86\u4E00\u4E9B\u5217\u670D\u52A1\u8FD0\u7EF4\u529F\u80FD\uFF0C\u5305\u62EC\u670D\u52A1\u67E5\u8BE2\u3001\u670D\u52A1\u6CBB\u7406\u89C4\u5219\u7BA1\u7406\u3001\u670D\u52A1\u6D4B\u8BD5\u3001\u670D\u52A1 Mock\u3001\u5355\u673A\u8FD0\u7EF4\u7B49\uFF0C\u65E8\u5728\u63D0\u9AD8 HSF \u670D\u52A1\u7814\u53D1\u7684\u6548\u7387\u3001\u8FD0\u7EF4\u7684\u4FBF\u6377\u6027</td></tr></tbody></table><p><img src="'+p+'" alt="" loading="lazy"></p><p>\u4ECE\u4E0A\u56FE\u53EF\u4EE5\u770B\u5230\uFF0C\u670D\u52A1\u63D0\u4F9B\u65B9\u5728\u542F\u52A8\u540E\u4F1A\u5411\u5730\u5740\u6CE8\u518C\u4E2D\u5FC3\u53D1\u5E03\u5730\u5740\uFF0C\u670D\u52A1\u6D88\u8D39\u65B9\u6839\u636E\u670D\u52A1\u540D\u5411\u5730\u5740\u6CE8\u518C\u4E2D\u5FC3\u8BA2\u9605\u670D\u52A1\u5730\u5740\uFF0C\u5F53\u670D\u52A1\u5730\u5740\u63A8\u9001\u5230\u670D\u52A1\u6D88\u8D39\u65B9\u540E\uFF0C\u670D\u52A1\u6D88\u8D39\u65B9\u5C31\u53EF\u4EE5\u4ECE\u5730\u5740\u5217\u8868\u4E2D\u9009\u62E9\u4E00\u4E2A\u5730\u5740\u53D1\u8D77RPC\u8C03\u7528\u3002</p><p>\u670D\u52A1\u63D0\u4F9B\u65B9\u5728\u53D1\u5E03\u5730\u5740\u7684\u540C\u65F6\u4F1A\u5C06\u670D\u52A1\u5143\u4FE1\u606F\u53D1\u5E03\u5230\u5143\u6570\u636E\u5B58\u50A8\u4E2D\u5FC3\uFF0CHSF\u63A7\u5236\u53F0\u901A\u8FC7\u8BBF\u95EE\u5143\u6570\u636E\u5B58\u50A8\u4E2D\u5FC3\u5411\u4F7F\u7528\u8005\u5C55\u793A\u670D\u52A1\u7684\u8BE6\u60C5\uFF0C\u540C\u65F6HSF\u63A7\u5236\u53F0\u8FD8\u53EF\u4EE5\u901A\u8FC7\u6301\u4E45\u5316\u914D\u7F6E\u4E2D\u5FC3\u548C\u5730\u5740\u6CE8\u518C\u4E2D\u5FC3\u5BA2\u6237\u7AEF\u67E5\u8BE2\u670D\u52A1\u4FE1\u606F\u548C\u89C4\u5219\u4FE1\u606F\u3002</p><h3 id="\u6A21\u5757" tabindex="-1"><a class="header-anchor" href="#\u6A21\u5757" aria-hidden="true">#</a> \u6A21\u5757</h3><p><img src="'+f+'" alt="" loading="lazy"></p><ul><li>\u5730\u5740\u6CE8\u518C\u4E2D\u5FC3\uFF1AConfigServer\u53EF\u4EE5\u7406\u89E3\u4E3A\u4E00\u4E2AIP\u5730\u5740\u7684\u7BA1\u7406\u4E2D\u5FC3\uFF0C\u5B83\u8D1F\u8D23\u5411\u6D88\u8D39\u8005\u7528\u6237\u6765\u63A8\u9001\u670D\u52A1\u7AEF\u7684\u5730\u5740\uFF0C\u6240\u4EE5\u5F00\u53D1\u4EBA\u5458\u53EA\u9700\u81EA\u5DF1\u914D\u7F6E\u6D88\u8D39\u7AEF\u6216\u8005\u670D\u52A1\u7AEF\u7684\u5730\u5740\u5C31\u597D\u3002<strong>\u670D\u52A1\u7AEF\u548C\u5BA2\u6237\u7AEF\u90FD\u4F1A\u8DDFCS\u5EFA\u7ACB\u957F\u8FDE\u63A5\uFF0C\u5E76\u4E14\u901A\u8FC7\u5FC3\u8DF3\u5305\u8FDB\u884C\u7EF4\u6301</strong>\u3002</li><li>\u914D\u7F6E\u4E2D\u5FC3\uFF1A\u5BF9\u4E8E\u5206\u5E03\u5F0F\u670D\u52A1\uFF0C\u5BA2\u6237\u7AEF\u5982\u4F55\u8C03\u7528\u5B9E\u73B0\u8D1F\u8F7D\u5747\u8861\u3002\u89C4\u5219\u914D\u7F6E\u4E2D\u5FC3Diamond\uFF0C\u5C31\u662F\u7528\u4E8E\u5B58\u653EHSF\u7684\u5404\u79CD\u89C4\u5219\uFF0C\u662F\u4E00\u4E2A\u6301\u4E45\u5316\u7684\u914D\u7F6E\u4E2D\u5FC3\uFF0C\u8FD9\u91CC\u5BA2\u6237\u7AEF\u662F\u4E3B\u52A8\u4ECEDiamond\u4E0A\u8FDB\u884C\u62C9\u53D6\u914D\u7F6E\uFF0C\u5E76\u4E14\u6CE8\u518C\u4E86Listener\uFF0C\u5F53\u8DEF\u7531\u89C4\u5219\u53D8\u5316\u65F6\uFF0CDiamond\u4F1A\u5C06\u65B0\u7684\u89C4\u5219\u91CD\u65B0\u63A8\u9001\u7ED9\u5BA2\u6237\u7AEF\uFF0C\u6240\u4EE5\uFF0C\u5BA2\u6237\u7AEF\u4E0D\u9700\u8981\u4E0EDiamond\u4FDD\u6301\u957F\u8FDE\u63A5\u3002</li><li>\u5BB9\u5668pandora\uFF1Apandora\u662FHSF\u7684\u57FA\u7840\u5BB9\u5668\uFF0C\u7528\u4E8E\u7BA1\u7406\u6574\u4E2AHSF\u7684\u751F\u547D\u5468\u671F\u548C\u4E8C\u65B9\u5305\u7684\u9694\u79BB\uFF0C\u540C\u65F6\uFF0C\u5176\u4ED6\u7684\u51E0\u4E2A\u4E2D\u95F4\u4EF6\uFF0CconfigServer\u548CDiamond\u4E5F\u5728pandora\u5BB9\u5668\u4E2D\u3002</li></ul><h3 id="\u5185\u90E8\u6846\u67B6" tabindex="-1"><a class="header-anchor" href="#\u5185\u90E8\u6846\u67B6" aria-hidden="true">#</a> \u5185\u90E8\u6846\u67B6</h3><p><img src="'+g+'" alt="" loading="lazy"></p><p>\u8FD94\u5757\u9886\u57DF\u4ECE\u4E0B\u5230\u4E0A\uFF0C\u5206\u522B\u662F\uFF1A\u6846\u67B6\u3001\u5E94\u7528\u3001\u670D\u52A1\u548C\u914D\u7F6E\u3002\u6846\u67B6\u63D0\u4F9B\u4E86\u57FA\u7840\u529F\u80FD\uFF0C\u8D1F\u8D23\u901A\u4FE1\u3001\u7EBF\u7A0B\u3001\u534F\u8BAE\u3001\u5E8F\u5217\u5316\u4EE5\u53CA\u7F16\u89E3\u7801\u76F8\u5173\u7684\u5DE5\u4F5C\uFF0C\u5B83\u4EEC\u63D0\u4F9B\u4E86\u826F\u597D\u7684\u62BD\u8C61\uFF0C\u6846\u67B6\u4E4B\u4E0A\u7684\u57DF\u53EA\u9700\u8981\u57FA\u4E8E\u8FD9\u4E9B\u62BD\u8C61\u5C31\u80FD\u5B8C\u6210\u4E00\u6B21\u9AD8\u6027\u80FD\u7684\u8C03\u7528\u3002</p><p>\u5E94\u7528\u4E3B\u8981\u9762\u5411\u670D\u52A1\u6846\u67B6\u7684\u6CE8\u518C\u548C\u53D1\u73B0\u8FC7\u7A0B\uFF0C\u662FHSF\u5B8C\u6210\u5206\u5E03\u5F0F\u8C03\u7528\u7684\u57FA\u7840\uFF0C\u5B83\u7528\u6765\u652F\u6491\u670D\u52A1\u3002\u670D\u52A1\u7684\u7C92\u5EA6\u6BD4\u5E94\u7528\u5C0F\uFF0C\u5B83\u5305\u542B\u4E86\u8C03\u7528\u94FE\u8DEF\u3001\u5730\u5740\u8DEF\u7531\u4EE5\u53CA\u8D1F\u8F7D\u5747\u8861\u7B49\u529F\u80FD\u3002\u5728\u670D\u52A1\u4E4B\u4E0A\u662F\u914D\u7F6E\uFF0C\u7528\u6237\u4F7F\u7528API\u6765\u5BF9\u5404\u5C42\u8FDB\u884C\u914D\u7F6E\uFF0C\u5E76\u751F\u6210\u8C03\u7528\u7684\u4EE3\u7406\u6216\u66B4\u9732\u670D\u52A1\u3002</p><p>\u6CBF\u7740\u5BA2\u6237\u7AEF\u914D\u7F6E\u94FE\u8DEF\u53EF\u4EE5\u770B\u5230\uFF0C\u7528\u6237\u914D\u7F6E\u4E86\u8C03\u7528\u7684\u63A5\u53E3\u3001\u7248\u672C\u4EE5\u53CA\u5206\u7EC4\u540E\uFF0C\u53EF\u4EE5\u6307\u5B9A\u8D1F\u8F7D\u5747\u8861\u7B56\u7565\u3001\u6CE8\u518C\u4E2D\u5FC3\u7C7B\u578B\u4EE5\u53CA\u652F\u6301\u4F55\u79CD\u534F\u8BAE\uFF0C\u5F53\u914D\u7F6E\u5B8C\u6210\u540E\uFF0C\u5C31\u53EF\u4EE5\u751F\u6210\u5BA2\u6237\u7AEF\u4EE3\u7406\uFF0C\u5F00\u59CB\u8FDC\u7A0B\u8C03\u7528\u4E86\u3002\u670D\u52A1\u7AEF\u914D\u7F6E\u6709\u6240\u4E0D\u540C\uFF0C\u9664\u4E86\u914D\u7F6E\u6CE8\u518C\u4E2D\u5FC3\u4EE5\u5916\uFF0C\u8FD8\u53EF\u4EE5\u914D\u7F6E\u5E8F\u5217\u5316\u65B9\u5F0F\u4EE5\u53CA\u7EBF\u7A0B\u6C60\uFF0C\u8FD9\u4E9B\u90FD\u4F1A\u5F71\u54CD\u670D\u52A1\u7AEF\u7684\u670D\u52A1\u80FD\u529B\u3002</p><p>\u670D\u52A1\u6CE8\u518C\u53D1\u73B0\u94FE\u8DEF\u6BD4\u8F83\u7B80\u5355\uFF0C\u5B83\u4EEC\u8D2F\u7A7F\u5728\u534F\u8BAE\u6D41\u7A0B\u4E2D\uFF0C\u8D1F\u8D23\u6CE8\u518C\u5730\u5740\u6216\u8005\u8BA2\u9605\u670D\u52A1\u3002</p><p>\u8C03\u7528\u94FE\u8DEF\u4ECE\u5BA2\u6237\u7AEF\u53D1\u8D77\u8C03\u7528\u5F00\u59CB\uFF0C\u7ECF\u5386\u4E86\u5BA2\u6237\u7AEF\u7684\u9009\u5740\u548C\u8D1F\u8F7D\u5747\u8861\u540E\uFF0C\u5C06\u53C2\u6570\u5BF9\u8C61\u5B8C\u6210\u5E8F\u5217\u5316\uFF0C\u7ECF\u8FC7\u6846\u67B6\u534F\u8BAE\u7F16\u7801\u540E\uFF0C\u901A\u8FC7\u7F51\u7EDC\u5C42\u53D1\u9001\u51FA\u53BB\u3002\u670D\u52A1\u7AEF\u63A5\u53D7\u5230\u6570\u636E\u540E\u8FDB\u884C\u89E3\u7801\uFF0C\u89E3\u7801\u83B7\u5F97\u7684\u4E8C\u8FDB\u5236\u534F\u8BAE\u6D3E\u53D1\u5230\u670D\u52A1\u7AEF\u7EBF\u7A0B\u5B8C\u6210\u53CD\u5E8F\u5217\u5316\uFF0C\u751F\u6210\u51FA\u53C2\u6570\u5BF9\u8C61\uFF0C\u6700\u7EC8\u5B8C\u6210\u53CD\u5C04\u8C03\u7528\u3002</p><p><img src="'+u+'" alt="" loading="lazy"></p><h3 id="\u8C03\u7528\u65B9\u5F0F" tabindex="-1"><a class="header-anchor" href="#\u8C03\u7528\u65B9\u5F0F" aria-hidden="true">#</a> \u8C03\u7528\u65B9\u5F0F</h3><ul><li>\u540C\u6B65\u5B9E\u65F6\u8C03\u7528\uFF1AHSF\u7684IO\u64CD\u4F5C\u90FD\u662F\u5F02\u6B65\u7684\uFF0C\u8FD9\u91CC\u7684\u540C\u6B65\u5176\u672C\u8D28\u662F\u505Afuture.get(timeout)\u5728\u8FD9\u4E2A\u70B9\u7B49\u5F85\u670D\u52A1\u7AEF\u7684\u8FD4\u56DE</li><li>Future\u5F02\u6B65\u8C03\u7528</li><li>Callback\u5F02\u6B65\u8C03\u7528\uFF08\u5BA2\u6237\u7AEF\u9700\u63D0\u4F9B\u56DE\u8C03\u65B9\u6CD5\uFF09</li><li>Generic\u8C03\u7528\uFF08\u4E0D\u4F9D\u8D56\u4E8C\u65B9\u5305\uFF0C\u901A\u8FC7\u4F20\u5165\u65B9\u6CD5\u540D\uFF0C\u65B9\u6CD5\u7B7E\u540D\u548C\u53C2\u6570\u503C\u7684\u65B9\u5F0F\u8C03\u7528\u670D\u52A1\uFF09</li><li>\u670D\u52A1\u7AEFasync\u8C03\u7528\uFF08\u5E94\u7528\u5C06\u901A\u8FC7AsyncContext\u5199\u54CD\u5E94\uFF09</li><li>HTTP\u8C03\u7528HSF(\u4ECE2.1.1.6\u7248\u672C\u5F00\u59CB)</li></ul><p>\u6B64\u5916Node\uFF0C C++\u90FD\u662F\u53EF\u4EE5\u4F7F\u7528HSF\u7684</p><h4 id="\u517C\u5BB9\u8C03\u7528" tabindex="-1"><a class="header-anchor" href="#\u517C\u5BB9\u8C03\u7528" aria-hidden="true">#</a> \u517C\u5BB9\u8C03\u7528</h4><p>\u4E00\u6B21\u8FDC\u7A0B\u670D\u52A1\u8C03\u7528\u90FD\u8981\u7ECF\u8FC7\u4EE3\u7406\u5C42\uFF0C\u534F\u8BAE\u5C42\u548CIO\u5C42\uFF0C\u5176\u4E2D\u5728\u534F\u8BAE\u5C42\uFF0C\u4F1A\u6839\u636E\u670D\u52A1\u63D0\u4F9B\u8005\u652F\u6301\u7684\u534F\u8BAE\u9009\u62E9\u4E0D\u540C\u7684\u534F\u8BAE\u8FDB\u884C\u901A\u4FE1\uFF0C\u5982\u679C\u670D\u52A1\u63D0\u4F9B\u8005\u662FDUBBO\uFF0C\u90A3\u4E48\u5C31\u4F1A\u6839\u636E\u5176\u652F\u6301\u7684\u534F\u8BAE\u9009\u62E9DUBBO1\u6216\u8005DUBBO2\u534F\u8BAE\u8FDB\u884C\u4F20\u8F93\uFF0C\u4E0A\u5C42\u670D\u52A1\u8C03\u7528\u8005\u4E0D\u4F1A\u611F\u77E5\u5230\u4EFB\u4F55\u4E0D\u540C\u3002</p><p><img src="'+m+'" alt="" loading="lazy"></p><h3 id="\u8D1F\u8F7D\u4F53\u7CFB" tabindex="-1"><a class="header-anchor" href="#\u8D1F\u8F7D\u4F53\u7CFB" aria-hidden="true">#</a> \u8D1F\u8F7D\u4F53\u7CFB</h3><p>HSF\u6D88\u8D39\u8005\u542F\u52A8\u7684\u65F6\u5019\uFF0C\u4F1A\u5411ConfigServer\u6CE8\u518C\u81EA\u5DF1\u8BA2\u9605\u7684\u670D\u52A1\u4FE1\u606F\uFF0C\u7136\u540ECS\u4F1A\u5C06\u8BE5\u670D\u52A1\u7684\u6240\u6709\u63D0\u4F9B\u8005IP\u63A8\u9001\u7ED9\u5BA2\u6237\u7AEF\uFF0C\u8FD9\u65F6\u5BA2\u6237\u7AEF\u5C31\u4F1A\u6839\u636E\u4ECE\u914D\u7F6E\u4E2D\u5FC3Diamond\u4E0A\u62C9\u4E0B\u7684\u89C4\u5219\u5BF9\u8FD9\u4E9BIP\u8FDB\u884C\u5206\u7C7B\u7EC4\u88C5\uFF0C\u7136\u540E\u8FD4\u56DE\u7ED9Consumer\u53BB\u968F\u673A\u8C03\u7528\uFF0C\u5B9E\u73B0\u8F6F\u8D1F\u8F7D\u7684\u529F\u80FD\u3002\u89C4\u5219\u7684\u53D1\u5E03\u90FD\u53EF\u4EE5\u5728hsfops\u5E73\u53F0\u7EDF\u4E00\u53D1\u5E03\u3002</p><ol><li>\u8DEF\u7531\u89C4\u5219\uFF1A\u4F18\u5148\u7EA7\u662F\u53C2\u6570\u7EA7\u8DEF\u7531 &gt; \u65B9\u6CD5\u7EA7\u8DEF\u7531 &gt; \u63A5\u53E3\u7EA7\u8DEF\u7531</li><li>\u5F52\u7EC4\u89C4\u5219\uFF1A\u6BCF\u4E2A\u5E94\u7528\u552F\u4E00\u7684\u4E00\u4E2A\u5F52\u7EC4\uFF0C\u53EA\u6709\u76F8\u540C\u5F52\u7EC4\u7684\u670D\u52A1\uFF08group\uFF09\u624D\u80FD\u8C03\u7528\uFF0C\u5BF9\u4E8E\u53D1\u5E03\u4E86\u540C\u4E00HSF\u670D\u52A1\u7684\u6240\u6709\u673A\u5668\u7684\u4E00\u4E2A\u5206\u7EC4\u3002\uFF08\u5982\u679C\u4E0D\u6E05\u695A\uFF0C\u4E00\u822C\u4E0D\u8981\u914D\u7F6E\uFF09\u3002</li><li>\u540C\u673A\u623F\u4F18\u5148\u89C4\u5219\uFF1AHSF\u673A\u623F\u6D41\u91CF\u63A7\u5236\u89C4\u5219\u7528\u4E8E\u5BF9\u8DE8\u673A\u623F\u95F4\u7684HSF\u8C03\u7528\u6D41\u91CF\u8FDB\u884C\u89C4\u5212\u63A7\u5236\uFF0C\u80FD\u591F\u4FDD\u8BC1HSF\u670D\u52A1\u6D88\u8D39\u8005\u5728\u8BF7\u6C42HSF\u670D\u52A1\u65F6\uFF0C\u4F18\u5148\u9009\u62E9\u4E0E\u670D\u52A1\u6D88\u8D39\u8005\u540C\u673A\u623F\u7684\u670D\u52A1\u63D0\u4F9B\u8005\u3002\u540C\u673A\u623F\u89C4\u5219\u9ED8\u8BA4\u662F\u5173\u95ED\u7684\u3002\u540C\u6837\u5728ops\u4E0A\u914D\u7F6E\u3002\u67093\u4E2A\u89C4\u5219\u5C5E\u6027\uFF1A</li></ol><ul><li>localPreferredSwitch\uFF1A on|off</li><li>threshold\uFF1A float\u503C\uFF0C\u751F\u6548\u9600\u503C\u7684\u8BA1\u7B97\u65B9\u6CD5\uFF1A\u670D\u52A1\u53EF\u7528\u6BD4\u4F8B=\u672C\u673A\u623F\u53EF\u7528\u673A\u5668\u6570\u91CF/\u670D\u52A1\u6240\u6709\u673A\u623F\u7684\u673A\u5668\u603B\u91CF\u5F53\u670D\u52A1\u53EF\u7528\u6BD4\u4F8B&gt;=threshold\u65F6\uFF0C\u542F\u7528\u672C\u5730\u673A\u623F\u4F18\u5148\u7B56\u7565\u5F53\u670D\u52A1\u53EF\u7528\u6BD4\u4F8B\u5C0F\u4E8Ethreshold\u65F6\uFF0C\u672C\u5730\u673A\u623F\u4F18\u5148\u7B56\u7565\u5173\u95ED\uFF0C\u670D\u52A1\u4ECD\u7136\u91C7\u7528\u968F\u673A\u8C03\u7528\u7684\u65B9\u5F0F</li><li>exclusions\uFF1A\u5982\u679C\u671F\u671B\u8BE5\u89C4\u5219\u53EA\u5BF9\u4E00\u90E8\u5206\u673A\u5668\u751F\u6548\uFF0C\u53EF\u4EE5\u4F7F\u7528\u8FD9\u4E00\u5C5E\u6027\u914D\u7F6E\u9700\u8981\u6392\u9664\u7684IP\uFF0C\u6BD4\u5982\uFF1A172.24.*,\u5C06\u8868\u793A\u8BE5\u89C4\u5219\u4E0D\u4F1A\u5E94\u7528\u4E8E\u6240\u6709172.24\u6253\u5934\u7684IP\u3002</li></ul><ol start="4"><li>\u6743\u91CD\u89C4\u5219\uFF1A\u4F7F\u7528\u573A\u666F\u4E00\u822C\u662F\u538B\u6D4B\u6216\u8005\u673A\u5668\u7684\u914D\u7F6E\u4E0D\u5747\u8861\u3002</li></ol><h2 id="dubbo" tabindex="-1"><a class="header-anchor" href="#dubbo" aria-hidden="true">#</a> Dubbo</h2>',42),_={href:"/notes/%E6%A1%86%E6%9E%B6/Dubbo.md",target:"_blank",rel:"noopener noreferrer"},y=s("Dubbo\u8BE6\u7EC6\u5185\u5BB9");function F(b,H){const t=l("ExternalLinkIcon");return o(),r(d,null,[x,e("p",null,[e("a",_,[y,i(t)])])],64)}var C=a(S,[["render",F],["__file","\u5206\u5E03\u5F0F\u670D\u52A1.html.vue"]]);export{C as default};
