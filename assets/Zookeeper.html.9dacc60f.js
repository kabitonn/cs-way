import{_ as s}from"./Dubbo\u67B6\u6784.fb1772ac.js";import{_ as t}from"./plugin-vue_export-helper.21dcd24c.js";import{r as n,c as p,a as e,b as r,F as i,f as d,d as a,o as l}from"./app.2e0a550f.js";var h="/cs-way/assets/ZooKeeper\u6570\u636E\u6A21\u578B.057f04e1.png",Z="/cs-way/assets/ZooKeeper\u67B6\u6784.51d3fffa.png",c="/cs-way/assets/ZooKeeper\u96C6\u7FA4\u89D2\u8272.22d7039b.png";const E={},g=d('<ul><li><a href="#Zookeeper-%E4%BB%8B%E7%BB%8D">Zookeeper \u4ECB\u7ECD</a><ul><li><a href="#ZooKeeper-%E7%9A%84%E7%94%B1%E6%9D%A5">ZooKeeper \u7684\u7531\u6765</a></li><li><a href="#ZooKeeper-%E6%A6%82%E8%A7%88">ZooKeeper \u6982\u89C8</a></li></ul></li><li><a href="#ZooKeeper-%E7%9A%84%E9%87%8D%E8%A6%81%E6%A6%82%E5%BF%B5">ZooKeeper \u7684\u91CD\u8981\u6982\u5FF5</a><ul><li><a href="#%E6%80%BB%E7%BB%93">\u603B\u7ED3</a></li><li><a href="#%E4%BC%9A%E8%AF%9DSession">\u4F1A\u8BDD\uFF08Session\uFF09</a></li><li><a href="#Znode">Znode</a></li><li><a href="#%E7%89%88%E6%9C%AC">\u7248\u672C</a></li><li><a href="#Watcher">Watcher</a></li><li><a href="#ACL">ACL</a></li></ul></li><li><a href="#ZooKeeper-%E7%89%B9%E7%82%B9">ZooKeeper \u7279\u70B9</a></li><li><a href="#ZooKeeper-%E8%AE%BE%E8%AE%A1%E7%9B%AE%E6%A0%87">ZooKeeper \u8BBE\u8BA1\u76EE\u6807</a><ul><li><a href="#%E7%AE%80%E5%8D%95%E7%9A%84%E6%95%B0%E6%8D%AE%E6%A8%A1%E5%9E%8B">\u7B80\u5355\u7684\u6570\u636E\u6A21\u578B</a></li><li><a href="#%E5%8F%AF%E6%9E%84%E5%BB%BA%E9%9B%86%E7%BE%A4">\u53EF\u6784\u5EFA\u96C6\u7FA4</a></li><li><a href="#%E9%A1%BA%E5%BA%8F%E8%AE%BF%E9%97%AE">\u987A\u5E8F\u8BBF\u95EE</a></li><li><a href="#%E9%AB%98%E6%80%A7%E8%83%BD">\u9AD8\u6027\u80FD</a></li></ul></li><li><a href="#ZooKeeper-%E9%9B%86%E7%BE%A4%E8%A7%92%E8%89%B2%E4%BB%8B%E7%BB%8D">ZooKeeper \u96C6\u7FA4\u89D2\u8272\u4ECB\u7ECD</a></li><li><a href="#ZooKeeper--ZAB%E5%8D%8F%E8%AE%AE--Paxos%E7%AE%97%E6%B3%95">ZooKeeper &amp; ZAB\u534F\u8BAE &amp; Paxos\u7B97\u6CD5</a><ul><li><a href="#ZAB%E5%8D%8F%E8%AE%AE--Paxos%E7%AE%97%E6%B3%95">ZAB\u534F\u8BAE &amp; Paxos\u7B97\u6CD5</a></li><li><a href="#ZAB-%E5%8D%8F%E8%AE%AE%E4%BB%8B%E7%BB%8D">ZAB \u534F\u8BAE\u4ECB\u7ECD</a></li><li><a href="#ZAB-%E5%8D%8F%E8%AE%AE%E4%B8%A4%E7%A7%8D%E5%9F%BA%E6%9C%AC%E7%9A%84%E6%A8%A1%E5%BC%8F%E5%B4%A9%E6%BA%83%E6%81%A2%E5%A4%8D%E5%92%8C%E6%B6%88%E6%81%AF%E5%B9%BF%E6%92%AD">ZAB \u534F\u8BAE\u4E24\u79CD\u57FA\u672C\u7684\u6A21\u5F0F\uFF1A\u5D29\u6E83\u6062\u590D\u548C\u6D88\u606F\u5E7F\u64AD</a></li></ul></li></ul><h1 id="zookeeper-\u4ECB\u7ECD" tabindex="-1"><a class="header-anchor" href="#zookeeper-\u4ECB\u7ECD" aria-hidden="true">#</a> Zookeeper \u4ECB\u7ECD</h1><h2 id="zookeeper-\u7684\u7531\u6765" tabindex="-1"><a class="header-anchor" href="#zookeeper-\u7684\u7531\u6765" aria-hidden="true">#</a> ZooKeeper \u7684\u7531\u6765</h2><p><strong>\u4E0B\u9762\u8FD9\u6BB5\u5185\u5BB9\u6458\u81EA\u300A\u4ECEPaxos\u5230Zookeeper\u300B\u7B2C\u56DB\u7AE0\u7B2C\u4E00\u8282\u7684\u67D0\u6BB5\u5185\u5BB9\uFF1A</strong></p><blockquote><p>Zookeeper\u6700\u65E9\u8D77\u6E90\u4E8E\u96C5\u864E\u7814\u7A76\u9662\u7684\u4E00\u4E2A\u7814\u7A76\u5C0F\u7EC4\u3002\u5728\u5F53\u65F6\uFF0C\u7814\u7A76\u4EBA\u5458\u53D1\u73B0\uFF0C\u5728\u96C5\u864E\u5185\u90E8\u5F88\u591A\u5927\u578B\u7CFB\u7EDF\u57FA\u672C\u90FD\u9700\u8981\u4F9D\u8D56\u4E00\u4E2A\u7C7B\u4F3C\u7684\u7CFB\u7EDF\u6765\u8FDB\u884C\u5206\u5E03\u5F0F\u534F\u8C03\uFF0C\u4F46\u662F\u8FD9\u4E9B\u7CFB\u7EDF\u5F80\u5F80\u90FD\u5B58\u5728\u5206\u5E03\u5F0F\u5355\u70B9\u95EE\u9898\u3002\u6240\u4EE5\uFF0C<strong>\u96C5\u864E\u7684\u5F00\u53D1\u4EBA\u5458\u5C31\u8BD5\u56FE\u5F00\u53D1\u4E00\u4E2A\u901A\u7528\u7684\u65E0\u5355\u70B9\u95EE\u9898\u7684\u5206\u5E03\u5F0F\u534F\u8C03\u6846\u67B6\uFF0C\u4EE5\u4FBF\u8BA9\u5F00\u53D1\u4EBA\u5458\u5C06\u7CBE\u529B\u96C6\u4E2D\u5728\u5904\u7406\u4E1A\u52A1\u903B\u8F91\u4E0A\u3002</strong></p><p>\u5173\u4E8E\u201CZooKeeper\u201D\u8FD9\u4E2A\u9879\u76EE\u7684\u540D\u5B57\uFF0C\u5176\u5B9E\u4E5F\u6709\u4E00\u6BB5\u8DA3\u95FB\u3002\u5728\u7ACB\u9879\u521D\u671F\uFF0C\u8003\u8651\u5230\u4E4B\u524D\u5185\u90E8\u5F88\u591A\u9879\u76EE\u90FD\u662F\u4F7F\u7528\u52A8\u7269\u7684\u540D\u5B57\u6765\u547D\u540D\u7684\uFF08\u4F8B\u5982\u8457\u540D\u7684Pig\u9879\u76EE),\u96C5\u864E\u7684\u5DE5\u7A0B\u5E08\u5E0C\u671B\u7ED9\u8FD9\u4E2A\u9879\u76EE\u4E5F\u53D6\u4E00\u4E2A\u52A8\u7269\u7684\u540D\u5B57\u3002\u65F6\u4EFB\u7814\u7A76\u9662\u7684\u9996\u5E2D\u79D1\u5B66\u5BB6RaghuRamakrishnan\u5F00\u73A9\u7B11\u5730\u8BF4\uFF1A\u201C\u5728\u8FD9\u6837\u4E0B\u53BB\uFF0C\u6211\u4EEC\u8FD9\u513F\u5C31\u53D8\u6210\u52A8\u7269\u56ED\u4E86\uFF01\u201D\u6B64\u8BDD\u4E00\u51FA\uFF0C\u5927\u5BB6\u7EB7\u7EB7\u8868\u793A\u5C31\u53EB\u52A8\u7269\u56ED\u7BA1\u7406\u5458\u5427\u4E00\u4E00\u4E00\u56E0\u4E3A\u5404\u4E2A\u4EE5\u52A8\u7269\u547D\u540D\u7684\u5206\u5E03\u5F0F\u7EC4\u4EF6\u653E\u5728\u4E00\u8D77\uFF0C<strong>\u96C5\u864E\u7684\u6574\u4E2A\u5206\u5E03\u5F0F\u7CFB\u7EDF\u770B\u4E0A\u53BB\u5C31\u50CF\u4E00\u4E2A\u5927\u578B\u7684\u52A8\u7269\u56ED\u4E86\uFF0C\u800CZookeeper\u6B63\u597D\u8981\u7528\u6765\u8FDB\u884C\u5206\u5E03\u5F0F\u73AF\u5883\u7684\u534F\u8C03\u4E00\u4E00\u4E8E\u662F\uFF0CZookeeper\u7684\u540D\u5B57\u4E5F\u5C31\u7531\u6B64\u8BDE\u751F\u4E86\u3002</strong></p></blockquote><h2 id="zookeeper-\u6982\u89C8" tabindex="-1"><a class="header-anchor" href="#zookeeper-\u6982\u89C8" aria-hidden="true">#</a> ZooKeeper \u6982\u89C8</h2><p>ZooKeeper \u662F\u4E00\u4E2A\u5F00\u6E90\u7684\u5206\u5E03\u5F0F\u534F\u8C03\u670D\u52A1\uFF0CZooKeeper\u6846\u67B6\u6700\u521D\u662F\u5728\u201CYahoo!&quot;\u4E0A\u6784\u5EFA\u7684\uFF0C\u7528\u4E8E\u4EE5\u7B80\u5355\u800C\u7A33\u5065\u7684\u65B9\u5F0F\u8BBF\u95EE\u4ED6\u4EEC\u7684\u5E94\u7528\u7A0B\u5E8F\u3002 \u540E\u6765\uFF0CApache ZooKeeper\u6210\u4E3AHadoop\uFF0CHBase\u548C\u5176\u4ED6\u5206\u5E03\u5F0F\u6846\u67B6\u4F7F\u7528\u7684\u6709\u7EC4\u7EC7\u670D\u52A1\u7684\u6807\u51C6\u3002 \u4F8B\u5982\uFF0CApache HBase\u4F7F\u7528ZooKeeper\u8DDF\u8E2A\u5206\u5E03\u5F0F\u6570\u636E\u7684\u72B6\u6001\u3002<strong>ZooKeeper \u7684\u8BBE\u8BA1\u76EE\u6807\u662F\u5C06\u90A3\u4E9B\u590D\u6742\u4E14\u5BB9\u6613\u51FA\u9519\u7684\u5206\u5E03\u5F0F\u4E00\u81F4\u6027\u670D\u52A1\u5C01\u88C5\u8D77\u6765\uFF0C\u6784\u6210\u4E00\u4E2A\u9AD8\u6548\u53EF\u9760\u7684\u539F\u8BED\u96C6\uFF0C\u5E76\u4EE5\u4E00\u7CFB\u5217\u7B80\u5355\u6613\u7528\u7684\u63A5\u53E3\u63D0\u4F9B\u7ED9\u7528\u6237\u4F7F\u7528\u3002</strong></p><blockquote><p><strong>\u539F\u8BED\uFF1A</strong> \u64CD\u4F5C\u7CFB\u7EDF\u6216\u8BA1\u7B97\u673A\u7F51\u7EDC\u7528\u8BED\u8303\u7574\u3002\u662F\u7531\u82E5\u5E72\u6761\u6307\u4EE4\u7EC4\u6210\u7684\uFF0C\u7528\u4E8E\u5B8C\u6210\u4E00\u5B9A\u529F\u80FD\u7684\u4E00\u4E2A\u8FC7\u7A0B\u3002\u5177\u6709\u4E0D\u53EF\u5206\u5272\u6027\uFF0C\u5373\u539F\u8BED\u7684\u6267\u884C\u5FC5\u987B\u662F\u8FDE\u7EED\u7684\uFF0C\u5728\u6267\u884C\u8FC7\u7A0B\u4E2D\u4E0D\u5141\u8BB8\u88AB\u4E2D\u65AD\u3002</p></blockquote><p><strong>ZooKeeper \u662F\u4E00\u4E2A\u5178\u578B\u7684\u5206\u5E03\u5F0F\u6570\u636E\u4E00\u81F4\u6027\u89E3\u51B3\u65B9\u6848\uFF0C\u5206\u5E03\u5F0F\u5E94\u7528\u7A0B\u5E8F\u53EF\u4EE5\u57FA\u4E8E ZooKeeper \u5B9E\u73B0\u8BF8\u5982\u6570\u636E\u53D1\u5E03/\u8BA2\u9605\u3001\u8D1F\u8F7D\u5747\u8861\u3001\u547D\u540D\u670D\u52A1\u3001\u5206\u5E03\u5F0F\u534F\u8C03/\u901A\u77E5\u3001\u96C6\u7FA4\u7BA1\u7406\u3001Master \u9009\u4E3E\u3001\u5206\u5E03\u5F0F\u9501\u548C\u5206\u5E03\u5F0F\u961F\u5217\u7B49\u529F\u80FD\u3002</strong></p><p><strong>Zookeeper \u4E00\u4E2A\u6700\u5E38\u7528\u7684\u4F7F\u7528\u573A\u666F\u5C31\u662F\u7528\u4E8E\u62C5\u4EFB\u670D\u52A1\u751F\u4EA7\u8005\u548C\u670D\u52A1\u6D88\u8D39\u8005\u7684\u6CE8\u518C\u4E2D\u5FC3(\u63D0\u4F9B\u53D1\u5E03\u8BA2\u9605\u670D\u52A1)\u3002</strong> \u670D\u52A1\u751F\u4EA7\u8005\u5C06\u81EA\u5DF1\u63D0\u4F9B\u7684\u670D\u52A1\u6CE8\u518C\u5230Zookeeper\u4E2D\u5FC3\uFF0C\u670D\u52A1\u7684\u6D88\u8D39\u8005\u5728\u8FDB\u884C\u670D\u52A1\u8C03\u7528\u7684\u65F6\u5019\u5148\u5230Zookeeper\u4E2D\u67E5\u627E\u670D\u52A1\uFF0C\u83B7\u53D6\u5230\u670D\u52A1\u751F\u4EA7\u8005\u7684\u8BE6\u7EC6\u4FE1\u606F\u4E4B\u540E\uFF0C\u518D\u53BB\u8C03\u7528\u670D\u52A1\u751F\u4EA7\u8005\u7684\u5185\u5BB9\u4E0E\u6570\u636E\u3002\u5982\u4E0B\u56FE\u6240\u793A\uFF0C\u5728 Dubbo\u67B6\u6784\u4E2D Zookeeper \u5C31\u62C5\u4EFB\u4E86\u6CE8\u518C\u4E2D\u5FC3\u8FD9\u4E00\u89D2\u8272\u3002</p><p><img src="'+s+'" alt="Dubbo" loading="lazy"></p><h1 id="zookeeper-\u7684\u91CD\u8981\u6982\u5FF5" tabindex="-1"><a class="header-anchor" href="#zookeeper-\u7684\u91CD\u8981\u6982\u5FF5" aria-hidden="true">#</a> ZooKeeper \u7684\u91CD\u8981\u6982\u5FF5</h1><h2 id="\u603B\u7ED3" tabindex="-1"><a class="header-anchor" href="#\u603B\u7ED3" aria-hidden="true">#</a> \u603B\u7ED3</h2><ul><li><strong>ZooKeeper \u672C\u8EAB\u5C31\u662F\u4E00\u4E2A\u5206\u5E03\u5F0F\u7A0B\u5E8F\uFF08\u53EA\u8981\u534A\u6570\u4EE5\u4E0A\u8282\u70B9\u5B58\u6D3B\uFF0CZooKeeper \u5C31\u80FD\u6B63\u5E38\u670D\u52A1\uFF09\u3002</strong></li><li><strong>\u4E3A\u4E86\u4FDD\u8BC1\u9AD8\u53EF\u7528\uFF0C\u6700\u597D\u662F\u4EE5\u96C6\u7FA4\u5F62\u6001\u6765\u90E8\u7F72 ZooKeeper\uFF0C\u8FD9\u6837\u53EA\u8981\u96C6\u7FA4\u4E2D\u5927\u90E8\u5206\u673A\u5668\u662F\u53EF\u7528\u7684\uFF08\u80FD\u591F\u5BB9\u5FCD\u4E00\u5B9A\u7684\u673A\u5668\u6545\u969C\uFF09\uFF0C\u90A3\u4E48 ZooKeeper \u672C\u8EAB\u4ECD\u7136\u662F\u53EF\u7528\u7684\u3002</strong></li><li><strong>ZooKeeper \u5C06\u6570\u636E\u4FDD\u5B58\u5728\u5185\u5B58\u4E2D\uFF0C\u8FD9\u4E5F\u5C31\u4FDD\u8BC1\u4E86\u9AD8\u541E\u5410\u91CF\u548C\u4F4E\u5EF6\u8FDF</strong>\uFF08\u4F46\u662F\u5185\u5B58\u9650\u5236\u4E86\u80FD\u591F\u5B58\u50A8\u7684\u5BB9\u91CF\u4E0D\u592A\u5927\uFF0C\u6B64\u9650\u5236\u4E5F\u662F\u4FDD\u6301znode\u4E2D\u5B58\u50A8\u7684\u6570\u636E\u91CF\u8F83\u5C0F\u7684\u8FDB\u4E00\u6B65\u539F\u56E0\uFF09\u3002</li><li><strong>ZooKeeper \u662F\u9AD8\u6027\u80FD\u7684\u3002 \u5728\u201C\u8BFB\u201D\u591A\u4E8E\u201C\u5199\u201D\u7684\u5E94\u7528\u7A0B\u5E8F\u4E2D\u5C24\u5176\u5730\u9AD8\u6027\u80FD\uFF0C\u56E0\u4E3A\u201C\u5199\u201D\u4F1A\u5BFC\u81F4\u6240\u6709\u7684\u670D\u52A1\u5668\u95F4\u540C\u6B65\u72B6\u6001\u3002</strong>\uFF08\u201C\u8BFB\u201D\u591A\u4E8E\u201C\u5199\u201D\u662F\u534F\u8C03\u670D\u52A1\u7684\u5178\u578B\u573A\u666F\u3002\uFF09</li><li><strong>ZooKeeper\u6709\u4E34\u65F6\u8282\u70B9\u7684\u6982\u5FF5\u3002 \u5F53\u521B\u5EFA\u4E34\u65F6\u8282\u70B9\u7684\u5BA2\u6237\u7AEF\u4F1A\u8BDD\u4E00\u76F4\u4FDD\u6301\u6D3B\u52A8\uFF0C\u77AC\u65F6\u8282\u70B9\u5C31\u4E00\u76F4\u5B58\u5728\u3002\u800C\u5F53\u4F1A\u8BDD\u7EC8\u7ED3\u65F6\uFF0C\u77AC\u65F6\u8282\u70B9\u88AB\u5220\u9664\u3002\u6301\u4E45\u8282\u70B9\u662F\u6307\u4E00\u65E6\u8FD9\u4E2AZNode\u88AB\u521B\u5EFA\u4E86\uFF0C\u9664\u975E\u4E3B\u52A8\u8FDB\u884CZNode\u7684\u79FB\u9664\u64CD\u4F5C\uFF0C\u5426\u5219\u8FD9\u4E2AZNode\u5C06\u4E00\u76F4\u4FDD\u5B58\u5728Zookeeper\u4E0A\u3002</strong></li><li>ZooKeeper \u5E95\u5C42\u5176\u5B9E\u53EA\u63D0\u4F9B\u4E86\u4E24\u4E2A\u529F\u80FD\uFF1A <ul><li>\u7BA1\u7406\uFF08\u5B58\u50A8\u3001\u8BFB\u53D6\uFF09\u7528\u6237\u7A0B\u5E8F\u63D0\u4EA4\u7684\u6570\u636E\uFF1B</li><li>\u4E3A\u7528\u6237\u7A0B\u5E8F\u63D0\u4F9B\u6570\u636E\u8282\u70B9\u76D1\u542C\u670D\u52A1\u3002</li></ul></li></ul><h2 id="\u4F1A\u8BDD-session" tabindex="-1"><a class="header-anchor" href="#\u4F1A\u8BDD-session" aria-hidden="true">#</a> \u4F1A\u8BDD\uFF08Session\uFF09</h2><p>Session \u6307\u7684\u662F ZooKeeper \u670D\u52A1\u5668\u4E0E\u5BA2\u6237\u7AEF\u4F1A\u8BDD\u3002<strong>\u5728 ZooKeeper \u4E2D\uFF0C\u4E00\u4E2A\u5BA2\u6237\u7AEF\u8FDE\u63A5\u662F\u6307\u5BA2\u6237\u7AEF\u548C\u670D\u52A1\u5668\u4E4B\u95F4\u7684\u4E00\u4E2A TCP \u957F\u8FDE\u63A5</strong>\u3002\u5BA2\u6237\u7AEF\u542F\u52A8\u7684\u65F6\u5019\uFF0C\u9996\u5148\u4F1A\u4E0E\u670D\u52A1\u5668\u5EFA\u7ACB\u4E00\u4E2A TCP \u8FDE\u63A5\uFF0C\u4ECE\u7B2C\u4E00\u6B21\u8FDE\u63A5\u5EFA\u7ACB\u5F00\u59CB\uFF0C\u5BA2\u6237\u7AEF\u4F1A\u8BDD\u7684\u751F\u547D\u5468\u671F\u4E5F\u5F00\u59CB\u4E86\u3002<strong>\u901A\u8FC7\u8FD9\u4E2A\u8FDE\u63A5\uFF0C\u5BA2\u6237\u7AEF\u80FD\u591F\u901A\u8FC7\u5FC3\u8DF3\u68C0\u6D4B\u4E0E\u670D\u52A1\u5668\u4FDD\u6301\u6709\u6548\u7684\u4F1A\u8BDD\uFF0C\u4E5F\u80FD\u591F\u5411Zookeeper\u670D\u52A1\u5668\u53D1\u9001\u8BF7\u6C42\u5E76\u63A5\u53D7\u54CD\u5E94\uFF0C\u540C\u65F6\u8FD8\u80FD\u591F\u901A\u8FC7\u8BE5\u8FDE\u63A5\u63A5\u6536\u6765\u81EA\u670D\u52A1\u5668\u7684Watch\u4E8B\u4EF6\u901A\u77E5\u3002</strong> Session\u7684<code>sessionTimeout</code>\u503C\u7528\u6765\u8BBE\u7F6E\u4E00\u4E2A\u5BA2\u6237\u7AEF\u4F1A\u8BDD\u7684\u8D85\u65F6\u65F6\u95F4\u3002\u5F53\u7531\u4E8E\u670D\u52A1\u5668\u538B\u529B\u592A\u5927\u3001\u7F51\u7EDC\u6545\u969C\u6216\u662F\u5BA2\u6237\u7AEF\u4E3B\u52A8\u65AD\u5F00\u8FDE\u63A5\u7B49\u5404\u79CD\u539F\u56E0\u5BFC\u81F4\u5BA2\u6237\u7AEF\u8FDE\u63A5\u65AD\u5F00\u65F6\uFF0C<strong>\u53EA\u8981\u5728<code>sessionTimeout</code>\u89C4\u5B9A\u7684\u65F6\u95F4\u5185\u80FD\u591F\u91CD\u65B0\u8FDE\u63A5\u4E0A\u96C6\u7FA4\u4E2D\u4EFB\u610F\u4E00\u53F0\u670D\u52A1\u5668\uFF0C\u90A3\u4E48\u4E4B\u524D\u521B\u5EFA\u7684\u4F1A\u8BDD\u4ECD\u7136\u6709\u6548\u3002</strong></p><p><strong>\u5728\u4E3A\u5BA2\u6237\u7AEF\u521B\u5EFA\u4F1A\u8BDD\u4E4B\u524D\uFF0C\u670D\u52A1\u7AEF\u9996\u5148\u4F1A\u4E3A\u6BCF\u4E2A\u5BA2\u6237\u7AEF\u90FD\u5206\u914D\u4E00\u4E2AsessionID\u3002\u7531\u4E8E sessionID \u662F Zookeeper \u4F1A\u8BDD\u7684\u4E00\u4E2A\u91CD\u8981\u6807\u8BC6\uFF0C\u8BB8\u591A\u4E0E\u4F1A\u8BDD\u76F8\u5173\u7684\u8FD0\u884C\u673A\u5236\u90FD\u662F\u57FA\u4E8E\u8FD9\u4E2A sessionID \u7684\uFF0C\u56E0\u6B64\uFF0C\u65E0\u8BBA\u662F\u54EA\u53F0\u670D\u52A1\u5668\u4E3A\u5BA2\u6237\u7AEF\u5206\u914D\u7684 sessionID\uFF0C\u90FD\u52A1\u5FC5\u4FDD\u8BC1\u5168\u5C40\u552F\u4E00\u3002</strong></p><h2 id="znode" tabindex="-1"><a class="header-anchor" href="#znode" aria-hidden="true">#</a> Znode</h2><p><strong>\u5728\u8C08\u5230\u5206\u5E03\u5F0F\u7684\u65F6\u5019\uFF0C\u6211\u4EEC\u901A\u5E38\u8BF4\u7684\u201C\u8282\u70B9&quot;\u662F\u6307\u7EC4\u6210\u96C6\u7FA4\u7684\u6BCF\u4E00\u53F0\u673A\u5668\u3002\u7136\u800C\uFF0C\u5728Zookeeper\u4E2D\uFF0C\u201C\u8282\u70B9&quot;\u5206\u4E3A\u4E24\u7C7B\uFF0C\u7B2C\u4E00\u7C7B\u540C\u6837\u662F\u6307\u6784\u6210\u96C6\u7FA4\u7684\u673A\u5668\uFF0C\u6211\u4EEC\u79F0\u4E4B\u4E3A\u673A\u5668\u8282\u70B9\uFF1B\u7B2C\u4E8C\u7C7B\u5219\u662F\u6307\u6570\u636E\u6A21\u578B\u4E2D\u7684\u6570\u636E\u5355\u5143\uFF0C\u6211\u4EEC\u79F0\u4E4B\u4E3A\u6570\u636E\u8282\u70B9\u4E00\u4E00ZNode\u3002</strong></p><p>Zookeeper\u5C06\u6240\u6709\u6570\u636E\u5B58\u50A8\u5728\u5185\u5B58\u4E2D\uFF0C\u6570\u636E\u6A21\u578B\u662F\u4E00\u68F5\u6811\uFF08Znode Tree)\uFF0C\u7531\u659C\u6760\uFF08/\uFF09\u7684\u8FDB\u884C\u5206\u5272\u7684\u8DEF\u5F84\uFF0C\u5C31\u662F\u4E00\u4E2AZnode\uFF0C\u4F8B\u5982/foo/path1\u3002\u6BCF\u4E2A\u4E0A\u90FD\u4F1A\u4FDD\u5B58\u81EA\u5DF1\u7684\u6570\u636E\u5185\u5BB9\uFF0C\u540C\u65F6\u8FD8\u4F1A\u4FDD\u5B58\u4E00\u7CFB\u5217\u5C5E\u6027\u4FE1\u606F\u3002</p><p><strong>\u5728Zookeeper\u4E2D\uFF0Cnode\u53EF\u4EE5\u5206\u4E3A\u6301\u4E45\u8282\u70B9\u548C\u4E34\u65F6\u8282\u70B9\u4E24\u7C7B\u3002\u6240\u8C13\u6301\u4E45\u8282\u70B9\u662F\u6307\u4E00\u65E6\u8FD9\u4E2AZNode\u88AB\u521B\u5EFA\u4E86\uFF0C\u9664\u975E\u4E3B\u52A8\u8FDB\u884CZNode\u7684\u79FB\u9664\u64CD\u4F5C\uFF0C\u5426\u5219\u8FD9\u4E2AZNode\u5C06\u4E00\u76F4\u4FDD\u5B58\u5728Zookeeper\u4E0A\u3002\u800C\u4E34\u65F6\u8282\u70B9\u5C31\u4E0D\u4E00\u6837\u4E86\uFF0C\u5B83\u7684\u751F\u547D\u5468\u671F\u548C\u5BA2\u6237\u7AEF\u4F1A\u8BDD\u7ED1\u5B9A\uFF0C\u4E00\u65E6\u5BA2\u6237\u7AEF\u4F1A\u8BDD\u5931\u6548\uFF0C\u90A3\u4E48\u8FD9\u4E2A\u5BA2\u6237\u7AEF\u521B\u5EFA\u7684\u6240\u6709\u4E34\u65F6\u8282\u70B9\u90FD\u4F1A\u88AB\u79FB\u9664\u3002</strong> \u53E6\u5916\uFF0CZooKeeper\u8FD8\u5141\u8BB8\u7528\u6237\u4E3A\u6BCF\u4E2A\u8282\u70B9\u6DFB\u52A0\u4E00\u4E2A\u7279\u6B8A\u7684\u5C5E\u6027\uFF1A<strong>SEQUENTIAL</strong>.\u4E00\u65E6\u8282\u70B9\u88AB\u6807\u8BB0\u4E0A\u8FD9\u4E2A\u5C5E\u6027\uFF0C\u90A3\u4E48\u5728\u8FD9\u4E2A\u8282\u70B9\u88AB\u521B\u5EFA\u7684\u65F6\u5019\uFF0CZookeeper\u4F1A\u81EA\u52A8\u5728\u5176\u8282\u70B9\u540D\u540E\u9762\u8FFD\u52A0\u4E0A\u4E00\u4E2A\u6574\u578B\u6570\u5B57\uFF0C\u8FD9\u4E2A\u6574\u578B\u6570\u5B57\u662F\u4E00\u4E2A\u7531\u7236\u8282\u70B9\u7EF4\u62A4\u7684\u81EA\u589E\u6570\u5B57\u3002</p><h2 id="\u7248\u672C" tabindex="-1"><a class="header-anchor" href="#\u7248\u672C" aria-hidden="true">#</a> \u7248\u672C</h2><p>\u5728\u524D\u9762\u6211\u4EEC\u5DF2\u7ECF\u63D0\u5230\uFF0CZookeeper \u7684\u6BCF\u4E2A ZNode \u4E0A\u90FD\u4F1A\u5B58\u50A8\u6570\u636E\uFF0C\u5BF9\u5E94\u4E8E\u6BCF\u4E2AZNode\uFF0CZookeeper \u90FD\u4F1A\u4E3A\u5176\u7EF4\u62A4\u4E00\u4E2A\u53EB\u4F5C <strong>Stat</strong> \u7684\u6570\u636E\u7ED3\u6784\uFF0CStat \u4E2D\u8BB0\u5F55\u4E86\u8FD9\u4E2A ZNode \u7684\u4E09\u4E2A\u6570\u636E\u7248\u672C\uFF0C\u5206\u522B\u662Fversion\uFF08\u5F53\u524DZNode\u7684\u7248\u672C\uFF09\u3001cversion\uFF08\u5F53\u524DZNode\u5B50\u8282\u70B9\u7684\u7248\u672C\uFF09\u548C aversion\uFF08\u5F53\u524DZNode\u7684ACL\u7248\u672C\uFF09\u3002</p><h2 id="watcher" tabindex="-1"><a class="header-anchor" href="#watcher" aria-hidden="true">#</a> Watcher</h2><p><strong>Watcher\uFF08\u4E8B\u4EF6\u76D1\u542C\u5668\uFF09\uFF0C\u662FZookeeper\u4E2D\u7684\u4E00\u4E2A\u5F88\u91CD\u8981\u7684\u7279\u6027\u3002Zookeeper\u5141\u8BB8\u7528\u6237\u5728\u6307\u5B9A\u8282\u70B9\u4E0A\u6CE8\u518C\u4E00\u4E9BWatcher\uFF0C\u5E76\u4E14\u5728\u4E00\u4E9B\u7279\u5B9A\u4E8B\u4EF6\u89E6\u53D1\u7684\u65F6\u5019\uFF0CZooKeeper\u670D\u52A1\u7AEF\u4F1A\u5C06\u4E8B\u4EF6\u901A\u77E5\u5230\u611F\u5174\u8DA3\u7684\u5BA2\u6237\u7AEF\u4E0A\u53BB\uFF0C\u8BE5\u673A\u5236\u662FZookeeper\u5B9E\u73B0\u5206\u5E03\u5F0F\u534F\u8C03\u670D\u52A1\u7684\u91CD\u8981\u7279\u6027\u3002</strong></p><h2 id="acl" tabindex="-1"><a class="header-anchor" href="#acl" aria-hidden="true">#</a> ACL</h2><p>Zookeeper\u91C7\u7528ACL\uFF08AccessControlLists\uFF09\u7B56\u7565\u6765\u8FDB\u884C\u6743\u9650\u63A7\u5236\uFF0C\u7C7B\u4F3C\u4E8E UNIX \u6587\u4EF6\u7CFB\u7EDF\u7684\u6743\u9650\u63A7\u5236\u3002Zookeeper \u5B9A\u4E49\u4E86\u5982\u4E0B5\u79CD\u6743\u9650\u3002</p><ul><li>CREATE\uFF1A\u521B\u5EFA\u5B50\u8282\u70B9\u7684\u6743\u9650</li><li>READ\uFF1A\u83B7\u53D6\u8282\u70B9\u6570\u636E\u548C\u5B50\u8282\u70B9\u5217\u8868\u7684\u6743\u9650</li><li>WRITE\uFF1A\u66F4\u65B0\u8282\u70B9\u6570\u636E\u7684\u6743\u9650</li><li>DELETE\uFF1A\u5220\u9664\u5B50\u8282\u70B9\u7684\u6743\u9650</li><li>ADMIN\uFF1A\u8BBE\u7F6E\u8282\u70B9ACL\u7684\u6743\u9650</li></ul><p>\u5176\u4E2D\u5C24\u5176\u9700\u8981\u6CE8\u610F\u7684\u662F\uFF0CCREATE\u548CDELETE\u8FD9\u4E24\u79CD\u6743\u9650\u90FD\u662F\u9488\u5BF9\u5B50\u8282\u70B9\u7684\u6743\u9650\u63A7\u5236\u3002</p><h1 id="zookeeper-\u7279\u70B9" tabindex="-1"><a class="header-anchor" href="#zookeeper-\u7279\u70B9" aria-hidden="true">#</a> ZooKeeper \u7279\u70B9</h1><ul><li><strong>\u987A\u5E8F\u4E00\u81F4\u6027\uFF1A</strong> \u4ECE\u540C\u4E00\u5BA2\u6237\u7AEF\u53D1\u8D77\u7684\u4E8B\u52A1\u8BF7\u6C42\uFF0C\u6700\u7EC8\u5C06\u4F1A\u4E25\u683C\u5730\u6309\u7167\u987A\u5E8F\u88AB\u5E94\u7528\u5230 ZooKeeper \u4E2D\u53BB\u3002</li><li><strong>\u539F\u5B50\u6027\uFF1A</strong> \u6240\u6709\u4E8B\u52A1\u8BF7\u6C42\u7684\u5904\u7406\u7ED3\u679C\u5728\u6574\u4E2A\u96C6\u7FA4\u4E2D\u6240\u6709\u673A\u5668\u4E0A\u7684\u5E94\u7528\u60C5\u51B5\u662F\u4E00\u81F4\u7684\uFF0C\u4E5F\u5C31\u662F\u8BF4\uFF0C\u8981\u4E48\u6574\u4E2A\u96C6\u7FA4\u4E2D\u6240\u6709\u7684\u673A\u5668\u90FD\u6210\u529F\u5E94\u7528\u4E86\u67D0\u4E00\u4E2A\u4E8B\u52A1\uFF0C\u8981\u4E48\u90FD\u6CA1\u6709\u5E94\u7528\u3002</li><li><strong>\u5355\u4E00\u7CFB\u7EDF\u6620\u50CF \uFF1A</strong> \u65E0\u8BBA\u5BA2\u6237\u7AEF\u8FDE\u5230\u54EA\u4E00\u4E2A ZooKeeper \u670D\u52A1\u5668\u4E0A\uFF0C\u5176\u770B\u5230\u7684\u670D\u52A1\u7AEF\u6570\u636E\u6A21\u578B\u90FD\u662F\u4E00\u81F4\u7684\u3002</li><li><strong>\u53EF\u9760\u6027\uFF1A</strong> \u4E00\u65E6\u4E00\u6B21\u66F4\u6539\u8BF7\u6C42\u88AB\u5E94\u7528\uFF0C\u66F4\u6539\u7684\u7ED3\u679C\u5C31\u4F1A\u88AB\u6301\u4E45\u5316\uFF0C\u76F4\u5230\u88AB\u4E0B\u4E00\u6B21\u66F4\u6539\u8986\u76D6\u3002</li></ul><h1 id="zookeeper-\u8BBE\u8BA1\u76EE\u6807" tabindex="-1"><a class="header-anchor" href="#zookeeper-\u8BBE\u8BA1\u76EE\u6807" aria-hidden="true">#</a> ZooKeeper \u8BBE\u8BA1\u76EE\u6807</h1><h2 id="\u7B80\u5355\u7684\u6570\u636E\u6A21\u578B" tabindex="-1"><a class="header-anchor" href="#\u7B80\u5355\u7684\u6570\u636E\u6A21\u578B" aria-hidden="true">#</a> \u7B80\u5355\u7684\u6570\u636E\u6A21\u578B</h2><p>ZooKeeper \u5141\u8BB8\u5206\u5E03\u5F0F\u8FDB\u7A0B\u901A\u8FC7\u5171\u4EAB\u7684\u5C42\u6B21\u7ED3\u6784\u547D\u540D\u7A7A\u95F4\u8FDB\u884C\u76F8\u4E92\u534F\u8C03\uFF0C\u8FD9\u4E0E\u6807\u51C6\u6587\u4EF6\u7CFB\u7EDF\u7C7B\u4F3C\u3002 \u540D\u79F0\u7A7A\u95F4\u7531 ZooKeeper \u4E2D\u7684\u6570\u636E\u5BC4\u5B58\u5668\u7EC4\u6210 - \u79F0\u4E3Aznode\uFF0C\u8FD9\u4E9B\u7C7B\u4F3C\u4E8E\u6587\u4EF6\u548C\u76EE\u5F55\u3002 \u4E0E\u4E3A\u5B58\u50A8\u8BBE\u8BA1\u7684\u5178\u578B\u6587\u4EF6\u7CFB\u7EDF\u4E0D\u540C\uFF0CZooKeeper\u6570\u636E\u4FDD\u5B58\u5728\u5185\u5B58\u4E2D\uFF0C\u8FD9\u610F\u5473\u7740ZooKeeper\u53EF\u4EE5\u5B9E\u73B0\u9AD8\u541E\u5410\u91CF\u548C\u4F4E\u5EF6\u8FDF\u3002</p><p><img src="'+h+'" alt="ZooKeeper\u6570\u636E\u6A21\u578B" loading="lazy"></p><h2 id="\u53EF\u6784\u5EFA\u96C6\u7FA4" tabindex="-1"><a class="header-anchor" href="#\u53EF\u6784\u5EFA\u96C6\u7FA4" aria-hidden="true">#</a> \u53EF\u6784\u5EFA\u96C6\u7FA4</h2><p><strong>\u4E3A\u4E86\u4FDD\u8BC1\u9AD8\u53EF\u7528\uFF0C\u6700\u597D\u662F\u4EE5\u96C6\u7FA4\u5F62\u6001\u6765\u90E8\u7F72 ZooKeeper\uFF0C\u8FD9\u6837\u53EA\u8981\u96C6\u7FA4\u4E2D\u5927\u90E8\u5206\u673A\u5668\u662F\u53EF\u7528\u7684\uFF08\u80FD\u591F\u5BB9\u5FCD\u4E00\u5B9A\u7684\u673A\u5668\u6545\u969C\uFF09\uFF0C\u90A3\u4E48zookeeper\u672C\u8EAB\u4ECD\u7136\u662F\u53EF\u7528\u7684\u3002</strong> \u5BA2\u6237\u7AEF\u5728\u4F7F\u7528 ZooKeeper \u65F6\uFF0C\u9700\u8981\u77E5\u9053\u96C6\u7FA4\u673A\u5668\u5217\u8868\uFF0C\u901A\u8FC7\u4E0E\u96C6\u7FA4\u4E2D\u7684\u67D0\u4E00\u53F0\u673A\u5668\u5EFA\u7ACB TCP \u8FDE\u63A5\u6765\u4F7F\u7528\u670D\u52A1\uFF0C\u5BA2\u6237\u7AEF\u4F7F\u7528\u8FD9\u4E2ATCP\u94FE\u63A5\u6765\u53D1\u9001\u8BF7\u6C42\u3001\u83B7\u53D6\u7ED3\u679C\u3001\u83B7\u53D6\u76D1\u542C\u4E8B\u4EF6\u4EE5\u53CA\u53D1\u9001\u5FC3\u8DF3\u5305\u3002\u5982\u679C\u8FD9\u4E2A\u8FDE\u63A5\u5F02\u5E38\u65AD\u5F00\u4E86\uFF0C\u5BA2\u6237\u7AEF\u53EF\u4EE5\u8FDE\u63A5\u5230\u53E6\u5916\u7684\u673A\u5668\u4E0A\u3002</p><p><strong>ZooKeeper \u5B98\u65B9\u63D0\u4F9B\u7684\u67B6\u6784\u56FE\uFF1A</strong></p><p><img src="'+Z+'" alt="ZooKeeper\u67B6\u6784" loading="lazy"></p><p>\u4E0A\u56FE\u4E2D\u6BCF\u4E00\u4E2AServer\u4EE3\u8868\u4E00\u4E2A\u5B89\u88C5Zookeeper\u670D\u52A1\u7684\u670D\u52A1\u5668\u3002\u7EC4\u6210 ZooKeeper \u670D\u52A1\u7684\u670D\u52A1\u5668\u90FD\u4F1A\u5728\u5185\u5B58\u4E2D\u7EF4\u62A4\u5F53\u524D\u7684\u670D\u52A1\u5668\u72B6\u6001\uFF0C\u5E76\u4E14\u6BCF\u53F0\u670D\u52A1\u5668\u4E4B\u95F4\u90FD\u4E92\u76F8\u4FDD\u6301\u7740\u901A\u4FE1\u3002\u96C6\u7FA4\u95F4\u901A\u8FC7 Zab \u534F\u8BAE\uFF08Zookeeper Atomic Broadcast\uFF09\u6765\u4FDD\u6301\u6570\u636E\u7684\u4E00\u81F4\u6027\u3002</p><h2 id="\u987A\u5E8F\u8BBF\u95EE" tabindex="-1"><a class="header-anchor" href="#\u987A\u5E8F\u8BBF\u95EE" aria-hidden="true">#</a> \u987A\u5E8F\u8BBF\u95EE</h2><p><strong>\u5BF9\u4E8E\u6765\u81EA\u5BA2\u6237\u7AEF\u7684\u6BCF\u4E2A\u66F4\u65B0\u8BF7\u6C42\uFF0CZooKeeper \u90FD\u4F1A\u5206\u914D\u4E00\u4E2A\u5168\u5C40\u552F\u4E00\u7684\u9012\u589E\u7F16\u53F7\uFF0C\u8FD9\u4E2A\u7F16\u53F7\u53CD\u5E94\u4E86\u6240\u6709\u4E8B\u52A1\u64CD\u4F5C\u7684\u5148\u540E\u987A\u5E8F\uFF0C\u5E94\u7528\u7A0B\u5E8F\u53EF\u4EE5\u4F7F\u7528 ZooKeeper \u8FD9\u4E2A\u7279\u6027\u6765\u5B9E\u73B0\u66F4\u9AD8\u5C42\u6B21\u7684\u540C\u6B65\u539F\u8BED\u3002</strong> <strong>\u8FD9\u4E2A\u7F16\u53F7\u4E5F\u53EB\u505A\u65F6\u95F4\u6233\u2014\u2014zxid\uFF08Zookeeper Transaction Id\uFF09</strong></p><h2 id="\u9AD8\u6027\u80FD" tabindex="-1"><a class="header-anchor" href="#\u9AD8\u6027\u80FD" aria-hidden="true">#</a> \u9AD8\u6027\u80FD</h2><p><strong>ZooKeeper \u662F\u9AD8\u6027\u80FD\u7684\u3002 \u5728\u201C\u8BFB\u201D\u591A\u4E8E\u201C\u5199\u201D\u7684\u5E94\u7528\u7A0B\u5E8F\u4E2D\u5C24\u5176\u5730\u9AD8\u6027\u80FD\uFF0C\u56E0\u4E3A\u201C\u5199\u201D\u4F1A\u5BFC\u81F4\u6240\u6709\u7684\u670D\u52A1\u5668\u95F4\u540C\u6B65\u72B6\u6001\u3002\uFF08\u201C\u8BFB\u201D\u591A\u4E8E\u201C\u5199\u201D\u662F\u534F\u8C03\u670D\u52A1\u7684\u5178\u578B\u573A\u666F\u3002\uFF09</strong></p><h1 id="zookeeper-\u96C6\u7FA4\u89D2\u8272\u4ECB\u7ECD" tabindex="-1"><a class="header-anchor" href="#zookeeper-\u96C6\u7FA4\u89D2\u8272\u4ECB\u7ECD" aria-hidden="true">#</a> ZooKeeper \u96C6\u7FA4\u89D2\u8272\u4ECB\u7ECD</h1><p><strong>\u6700\u5178\u578B\u96C6\u7FA4\u6A21\u5F0F\uFF1A Master/Slave \u6A21\u5F0F\uFF08\u4E3B\u5907\u6A21\u5F0F\uFF09</strong>\u3002\u5728\u8FD9\u79CD\u6A21\u5F0F\u4E2D\uFF0C\u901A\u5E38 Master\u670D\u52A1\u5668\u4F5C\u4E3A\u4E3B\u670D\u52A1\u5668\u63D0\u4F9B\u5199\u670D\u52A1\uFF0C\u5176\u4ED6\u7684 Slave \u670D\u52A1\u5668\u4ECE\u670D\u52A1\u5668\u901A\u8FC7\u5F02\u6B65\u590D\u5236\u7684\u65B9\u5F0F\u83B7\u53D6 Master \u670D\u52A1\u5668\u6700\u65B0\u7684\u6570\u636E\u63D0\u4F9B\u8BFB\u670D\u52A1\u3002</p><p>\u4F46\u662F\uFF0C<strong>\u5728 ZooKeeper \u4E2D\u6CA1\u6709\u9009\u62E9\u4F20\u7EDF\u7684 Master/Slave \u6982\u5FF5\uFF0C\u800C\u662F\u5F15\u5165\u4E86Leader\u3001Follower \u548C Observer \u4E09\u79CD\u89D2\u8272</strong>\u3002\u5982\u4E0B\u56FE\u6240\u793A</p><p><img src="'+c+'" alt="" loading="lazy"></p><p><strong>ZooKeeper \u96C6\u7FA4\u4E2D\u7684\u6240\u6709\u673A\u5668\u901A\u8FC7\u4E00\u4E2A Leader \u9009\u4E3E\u8FC7\u7A0B\u6765\u9009\u5B9A\u4E00\u53F0\u79F0\u4E3A \u201CLeader\u201D \u7684\u673A\u5668\uFF0CLeader \u65E2\u53EF\u4EE5\u4E3A\u5BA2\u6237\u7AEF\u63D0\u4F9B\u5199\u670D\u52A1\u53C8\u80FD\u63D0\u4F9B\u8BFB\u670D\u52A1\u3002\u9664\u4E86 Leader \u5916\uFF0CFollower \u548C Observer \u90FD\u53EA\u80FD\u63D0\u4F9B\u8BFB\u670D\u52A1\u3002Follower \u548C Observer \u552F\u4E00\u7684\u533A\u522B\u5728\u4E8E Observer \u673A\u5668\u4E0D\u53C2\u4E0E Leader \u7684\u9009\u4E3E\u8FC7\u7A0B\uFF0C\u4E5F\u4E0D\u53C2\u4E0E\u5199\u64CD\u4F5C\u7684\u201C\u8FC7\u534A\u5199\u6210\u529F\u201D\u7B56\u7565\uFF0C\u56E0\u6B64 Observer \u673A\u5668\u53EF\u4EE5\u5728\u4E0D\u5F71\u54CD\u5199\u6027\u80FD\u7684\u60C5\u51B5\u4E0B\u63D0\u5347\u96C6\u7FA4\u7684\u8BFB\u6027\u80FD\u3002</strong></p><div><table><tr><td colspan="2">\u89D2\u8272</td><td>\u4E3B\u8981\u5DE5\u4F5C\u63CF\u8FF0</td></tr><tr><td colspan="2">\u9886\u5BFC\u8005(Leader)</td><td> 1. \u4E8B\u52A1\u8BF7\u6C42\u7684\u552F\u4E00\u8C03\u5EA6\u548C\u5904\u7406\u8005\uFF0C\u4FDD\u8BC1\u96C6\u7FA4\u4E8B\u52A1\u5904\u7406\u7684\u987A\u5E8F\u6027 2. \u96C6\u7FA4\u5185\u90E8\u4E2A\u670D\u52A1\u5668\u7684\u8C03\u5EA6\u8005</td></tr><tr><td rowspan="2">\u5B66\u4E60\u8005(Learner)</td><td>\u8DDF\u968F\u8005(Follower)</td><td> 1. \u5904\u7406\u5BA2\u6237\u7AEF\u975E\u4E8B\u52A1\u8BF7\u6C42\uFF0C\u8F6C\u53D1\u4E8B\u52A1\u8BF7\u6C42\u7ED9Leader\u670D\u52A1\u5668 2. \u53C2\u4E0E\u4E8B\u52A1\u8BF7\u6C42Proposal\u7684\u6295\u7968 3. \u53C2\u4E0ELeader\u9009\u4E3E\u7684\u6295\u7968</td></tr><tr><td>\u89C2\u5BDF\u8005(Observer)</td><td>Follower\u548CObserver\u552F\u4E00\u7684\u533A\u522B\u5728\u4E8EObserver\u673A\u5668\u4E0D\u53C2\u4E0ELeader\u7684\u9009\u4E3E\uFF0C\u4E5F\u4E0D\u53C2\u4E0E\u5199\u64CD\u4F5C\u7684&quot;\u8FC7\u534A\u5199\u6210\u529F&quot;\u7B56\u7565\uFF0C \u56E0\u6B64Observer\u673A\u5668\u53EF\u4EE5\u4E0D\u5F71\u54CD\u5199\u6027\u80FD\u7684\u60C5\u51B5\u4E0B\u63D0\u5347\u96C6\u7FA4\u7684\u8BFB\u6027\u80FD</td></tr><tr><td colspan="2">\u5BA2\u6237\u7AEF(Client)</td><td>\u8BF7\u6C42\u53D1\u8D77\u65B9</td></tr></table></div><p><strong>\u5F53 Leader \u670D\u52A1\u5668\u51FA\u73B0\u7F51\u7EDC\u4E2D\u65AD\u3001\u5D29\u6E83\u9000\u51FA\u4E0E\u91CD\u542F\u7B49\u5F02\u5E38\u60C5\u51B5\u65F6\uFF0CZAB \u534F\u8BAE\u5C31\u4F1A\u8FDB\u4EBA\u6062\u590D\u6A21\u5F0F\u5E76\u9009\u4E3E\u4EA7\u751F\u65B0\u7684Leader\u670D\u52A1\u5668\u3002\u8FD9\u4E2A\u8FC7\u7A0B\u5927\u81F4\u662F\u8FD9\u6837\u7684\uFF1A</strong></p><ol><li>Leader election\uFF08\u9009\u4E3E\u9636\u6BB5\uFF09\uFF1A\u8282\u70B9\u5728\u4E00\u5F00\u59CB\u90FD\u5904\u4E8E\u9009\u4E3E\u9636\u6BB5\uFF0C\u53EA\u8981\u6709\u4E00\u4E2A\u8282\u70B9\u5F97\u5230\u8D85\u534A\u6570\u8282\u70B9\u7684\u7968\u6570\uFF0C\u5B83\u5C31\u53EF\u4EE5\u5F53\u9009\u51C6 leader\u3002</li><li>Discovery\uFF08\u53D1\u73B0\u9636\u6BB5\uFF09\uFF1A\u5728\u8FD9\u4E2A\u9636\u6BB5\uFF0Cfollowers \u8DDF\u51C6 leader \u8FDB\u884C\u901A\u4FE1\uFF0C\u540C\u6B65 followers \u6700\u8FD1\u63A5\u6536\u7684\u4E8B\u52A1\u63D0\u8BAE\u3002</li><li>Synchronization\uFF08\u540C\u6B65\u9636\u6BB5\uFF09:\u540C\u6B65\u9636\u6BB5\u4E3B\u8981\u662F\u5229\u7528 leader \u524D\u4E00\u9636\u6BB5\u83B7\u5F97\u7684\u6700\u65B0\u63D0\u8BAE\u5386\u53F2\uFF0C\u540C\u6B65\u96C6\u7FA4\u4E2D\u6240\u6709\u7684\u526F\u672C\u3002\u540C\u6B65\u5B8C\u6210\u4E4B\u540E \u51C6 leader \u624D\u4F1A\u6210\u4E3A\u771F\u6B63\u7684 leader\u3002</li><li>Broadcast\uFF08\u5E7F\u64AD\u9636\u6BB5\uFF09 \u5230\u4E86\u8FD9\u4E2A\u9636\u6BB5\uFF0CZookeeper \u96C6\u7FA4\u624D\u80FD\u6B63\u5F0F\u5BF9\u5916\u63D0\u4F9B\u4E8B\u52A1\u670D\u52A1\uFF0C\u5E76\u4E14 leader \u53EF\u4EE5\u8FDB\u884C\u6D88\u606F\u5E7F\u64AD\u3002\u540C\u65F6\u5982\u679C\u6709\u65B0\u7684\u8282\u70B9\u52A0\u5165\uFF0C\u8FD8\u9700\u8981\u5BF9\u65B0\u8282\u70B9\u8FDB\u884C\u540C\u6B65\u3002</li></ol><h1 id="zookeeper-zab\u534F\u8BAE-paxos\u7B97\u6CD5" tabindex="-1"><a class="header-anchor" href="#zookeeper-zab\u534F\u8BAE-paxos\u7B97\u6CD5" aria-hidden="true">#</a> ZooKeeper &amp; ZAB\u534F\u8BAE &amp; Paxos\u7B97\u6CD5</h1><h2 id="zab\u534F\u8BAE-paxos\u7B97\u6CD5" tabindex="-1"><a class="header-anchor" href="#zab\u534F\u8BAE-paxos\u7B97\u6CD5" aria-hidden="true">#</a> ZAB\u534F\u8BAE &amp; Paxos\u7B97\u6CD5</h2><p>Paxos \u7B97\u6CD5\u5E94\u8BE5\u53EF\u4EE5\u8BF4\u662F ZooKeeper \u7684\u7075\u9B42\u4E86\u3002\u4F46\u662F\uFF0CZooKeeper \u5E76\u6CA1\u6709\u5B8C\u5168\u91C7\u7528 Paxos\u7B97\u6CD5 \uFF0C\u800C\u662F\u4F7F\u7528 ZAB \u534F\u8BAE\u4F5C\u4E3A\u5176\u4FDD\u8BC1\u6570\u636E\u4E00\u81F4\u6027\u7684\u6838\u5FC3\u7B97\u6CD5\u3002\u53E6\u5916\uFF0C\u5728ZooKeeper\u7684\u5B98\u65B9\u6587\u6863\u4E2D\u4E5F\u6307\u51FA\uFF0CZAB\u534F\u8BAE\u5E76\u4E0D\u50CF Paxos \u7B97\u6CD5\u90A3\u6837\uFF0C\u662F\u4E00\u79CD\u901A\u7528\u7684\u5206\u5E03\u5F0F\u4E00\u81F4\u6027\u7B97\u6CD5\uFF0C\u5B83\u662F\u4E00\u79CD\u7279\u522B\u4E3AZookeeper\u8BBE\u8BA1\u7684\u5D29\u6E83\u53EF\u6062\u590D\u7684\u539F\u5B50\u6D88\u606F\u5E7F\u64AD\u7B97\u6CD5\u3002</p><h2 id="zab-\u534F\u8BAE\u4ECB\u7ECD" tabindex="-1"><a class="header-anchor" href="#zab-\u534F\u8BAE\u4ECB\u7ECD" aria-hidden="true">#</a> ZAB \u534F\u8BAE\u4ECB\u7ECD</h2><p><strong>ZAB\uFF08ZooKeeper Atomic Broadcast \u539F\u5B50\u5E7F\u64AD\uFF09 \u534F\u8BAE\u662F\u4E3A\u5206\u5E03\u5F0F\u534F\u8C03\u670D\u52A1 ZooKeeper \u4E13\u95E8\u8BBE\u8BA1\u7684\u4E00\u79CD\u652F\u6301\u5D29\u6E83\u6062\u590D\u7684\u539F\u5B50\u5E7F\u64AD\u534F\u8BAE\u3002 \u5728 ZooKeeper \u4E2D\uFF0C\u4E3B\u8981\u4F9D\u8D56 ZAB \u534F\u8BAE\u6765\u5B9E\u73B0\u5206\u5E03\u5F0F\u6570\u636E\u4E00\u81F4\u6027\uFF0C\u57FA\u4E8E\u8BE5\u534F\u8BAE\uFF0CZooKeeper \u5B9E\u73B0\u4E86\u4E00\u79CD\u4E3B\u5907\u6A21\u5F0F\u7684\u7CFB\u7EDF\u67B6\u6784\u6765\u4FDD\u6301\u96C6\u7FA4\u4E2D\u5404\u4E2A\u526F\u672C\u4E4B\u95F4\u7684\u6570\u636E\u4E00\u81F4\u6027\u3002</strong></p><h2 id="zab-\u534F\u8BAE\u4E24\u79CD\u57FA\u672C\u7684\u6A21\u5F0F-\u5D29\u6E83\u6062\u590D\u548C\u6D88\u606F\u5E7F\u64AD" tabindex="-1"><a class="header-anchor" href="#zab-\u534F\u8BAE\u4E24\u79CD\u57FA\u672C\u7684\u6A21\u5F0F-\u5D29\u6E83\u6062\u590D\u548C\u6D88\u606F\u5E7F\u64AD" aria-hidden="true">#</a> ZAB \u534F\u8BAE\u4E24\u79CD\u57FA\u672C\u7684\u6A21\u5F0F\uFF1A\u5D29\u6E83\u6062\u590D\u548C\u6D88\u606F\u5E7F\u64AD</h2><p>ZAB\u534F\u8BAE\u5305\u62EC\u4E24\u79CD\u57FA\u672C\u7684\u6A21\u5F0F\uFF0C\u5206\u522B\u662F <strong>\u5D29\u6E83\u6062\u590D\u548C\u6D88\u606F\u5E7F\u64AD</strong>\u3002\u5F53\u6574\u4E2A\u670D\u52A1\u6846\u67B6\u5728\u542F\u52A8\u8FC7\u7A0B\u4E2D\uFF0C\u6216\u662F\u5F53 Leader \u670D\u52A1\u5668\u51FA\u73B0\u7F51\u7EDC\u4E2D\u65AD\u3001\u5D29\u6E83\u9000\u51FA\u4E0E\u91CD\u542F\u7B49\u5F02\u5E38\u60C5\u51B5\u65F6\uFF0CZAB \u534F\u8BAE\u5C31\u4F1A\u8FDB\u4EBA\u6062\u590D\u6A21\u5F0F\u5E76\u9009\u4E3E\u4EA7\u751F\u65B0\u7684Leader\u670D\u52A1\u5668\u3002\u5F53\u9009\u4E3E\u4EA7\u751F\u4E86\u65B0\u7684 Leader \u670D\u52A1\u5668\uFF0C\u540C\u65F6\u96C6\u7FA4\u4E2D\u5DF2\u7ECF\u6709\u8FC7\u534A\u7684\u673A\u5668\u4E0E\u8BE5Leader\u670D\u52A1\u5668\u5B8C\u6210\u4E86\u72B6\u6001\u540C\u6B65\u4E4B\u540E\uFF0CZAB\u534F\u8BAE\u5C31\u4F1A\u9000\u51FA\u6062\u590D\u6A21\u5F0F\u3002\u5176\u4E2D\uFF0C<strong>\u6240\u8C13\u7684\u72B6\u6001\u540C\u6B65\u662F\u6307\u6570\u636E\u540C\u6B65\uFF0C\u7528\u6765\u4FDD\u8BC1\u96C6\u7FA4\u4E2D\u5B58\u5728\u8FC7\u534A\u7684\u673A\u5668\u80FD\u591F\u548CLeader\u670D\u52A1\u5668\u7684\u6570\u636E\u72B6\u6001\u4FDD\u6301\u4E00\u81F4</strong>\u3002</p><p><strong>\u5F53\u96C6\u7FA4\u4E2D\u5DF2\u7ECF\u6709\u8FC7\u534A\u7684Follower\u670D\u52A1\u5668\u5B8C\u6210\u4E86\u548CLeader\u670D\u52A1\u5668\u7684\u72B6\u6001\u540C\u6B65\uFF0C\u90A3\u4E48\u6574\u4E2A\u670D\u52A1\u6846\u67B6\u5C31\u53EF\u4EE5\u8FDB\u4EBA\u6D88\u606F\u5E7F\u64AD\u6A21\u5F0F\u4E86\u3002</strong> \u5F53\u4E00\u53F0\u540C\u6837\u9075\u5B88ZAB\u534F\u8BAE\u7684\u670D\u52A1\u5668\u542F\u52A8\u540E\u52A0\u4EBA\u5230\u96C6\u7FA4\u4E2D\u65F6\uFF0C\u5982\u679C\u6B64\u65F6\u96C6\u7FA4\u4E2D\u5DF2\u7ECF\u5B58\u5728\u4E00\u4E2ALeader\u670D\u52A1\u5668\u5728\u8D1F\u8D23\u8FDB\u884C\u6D88\u606F\u5E7F\u64AD\uFF0C\u90A3\u4E48\u65B0\u52A0\u4EBA\u7684\u670D\u52A1\u5668\u5C31\u4F1A\u81EA\u89C9\u5730\u8FDB\u4EBA\u6570\u636E\u6062\u590D\u6A21\u5F0F\uFF1A\u627E\u5230Leader\u6240\u5728\u7684\u670D\u52A1\u5668\uFF0C\u5E76\u4E0E\u5176\u8FDB\u884C\u6570\u636E\u540C\u6B65\uFF0C\u7136\u540E\u4E00\u8D77\u53C2\u4E0E\u5230\u6D88\u606F\u5E7F\u64AD\u6D41\u7A0B\u4E2D\u53BB\u3002\u6B63\u5982\u4E0A\u6587\u4ECB\u7ECD\u4E2D\u6240\u8BF4\u7684\uFF0CZooKeeper\u8BBE\u8BA1\u6210\u53EA\u5141\u8BB8\u552F\u4E00\u7684\u4E00\u4E2ALeader\u670D\u52A1\u5668\u6765\u8FDB\u884C\u4E8B\u52A1\u8BF7\u6C42\u7684\u5904\u7406\u3002Leader\u670D\u52A1\u5668\u5728\u63A5\u6536\u5230\u5BA2\u6237\u7AEF\u7684\u4E8B\u52A1\u8BF7\u6C42\u540E\uFF0C\u4F1A\u751F\u6210\u5BF9\u5E94\u7684\u4E8B\u52A1\u63D0\u6848\u5E76\u53D1\u8D77\u4E00\u8F6E\u5E7F\u64AD\u534F\u8BAE\uFF1B\u800C\u5982\u679C\u96C6\u7FA4\u4E2D\u7684\u5176\u4ED6\u673A\u5668\u63A5\u6536\u5230\u5BA2\u6237\u7AEF\u7684\u4E8B\u52A1\u8BF7\u6C42\uFF0C\u90A3\u4E48\u8FD9\u4E9B\u975ELeader\u670D\u52A1\u5668\u4F1A\u9996\u5148\u5C06\u8FD9\u4E2A\u4E8B\u52A1\u8BF7\u6C42\u8F6C\u53D1\u7ED9Leader\u670D\u52A1\u5668\u3002</p><p>\u5173\u4E8E <strong>ZAB \u534F\u8BAE&amp;Paxos\u7B97\u6CD5</strong> \u9700\u8981\u8BB2\u548C\u7406\u89E3\u7684\u4E1C\u897F\u592A\u591A\u4E86\u3002\u63A8\u8350\u9605\u8BFB\u4E0B\u9762\u4E24\u7BC7\u6587\u7AE0\uFF1A</p>',61),A={href:"http://codemacro.com/2014/10/15/explain-poxos/",target:"_blank",rel:"noopener noreferrer"},B=a("\u56FE\u89E3 Paxos \u4E00\u81F4\u6027\u534F\u8BAE"),K={href:"https://dbaplus.cn/news-141-1875-1.html",target:"_blank",rel:"noopener noreferrer"},u=a("Zookeeper ZAB \u534F\u8BAE\u5206\u6790"),f=e("p",null,"\u5173\u4E8E\u5982\u4F55\u4F7F\u7528 zookeeper \u5B9E\u73B0\u5206\u5E03\u5F0F\u9501\uFF0C\u53EF\u4EE5\u67E5\u770B\u4E0B\u9762\u8FD9\u7BC7\u6587\u7AE0\uFF1A",-1),k=e("ul",null,[e("li")],-1),b={href:"https://blog.csdn.net/qiangcuo6087/article/details/79067136",target:"_blank",rel:"noopener noreferrer"},x=a("10\u5206\u949F\u770B\u61C2\uFF01\u57FA\u4E8EZookeeper\u7684\u5206\u5E03\u5F0F\u9501");function _(L,m){const o=n("ExternalLinkIcon");return l(),p(i,null,[g,e("ul",null,[e("li",null,[e("a",A,[B,r(o)])]),e("li",null,[e("a",K,[u,r(o)])])]),f,k,e("p",null,[e("a",b,[x,r(o)])])],64)}var C=t(E,[["render",_],["__file","Zookeeper.html.vue"]]);export{C as default};
