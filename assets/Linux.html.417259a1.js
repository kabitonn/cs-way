const l={key:"v-3c32675b",path:"/notes/%E6%93%8D%E4%BD%9C%E7%B3%BB%E7%BB%9F/Linux.html",title:"\u4E00\u3001\u5E38\u7528\u64CD\u4F5C\u4EE5\u53CA\u6982\u5FF5",lang:"zh-CN",frontmatter:{summary:"\u4E00\u3001\u5E38\u7528\u64CD\u4F5C\u4EE5\u53CA\u6982\u5FF5; \u5FEB\u6377\u952E; \u6C42\u52A9; 1. --help; 2. man; 3. info; 4. doc; \u5173\u673A; 1. who; 2. sync; 3. shutdown; PATH; sudo; \u5305\u7BA1\u7406\u5DE5\u5177; \u53D1\u884C\u7248; VIM \u4E09\u4E2A\u6A21\u5F0F; GNU; \u5F00\u6E90\u534F\u8BAE; \u4E8C\u3001\u78C1\u76D8; \u78C1\u76D8\u63A5\u53E3; 1. IDE; 2. SATA; 3. SCSI; 4. SAS",head:[["meta",{property:"og:url",content:"https://vuepress-theme-hope-v2-demo.mrhope.site/cs-way/notes/%E6%93%8D%E4%BD%9C%E7%B3%BB%E7%BB%9F/Linux.html"}],["meta",{property:"og:site_name",content:"CS Way"}],["meta",{property:"og:title",content:"\u4E00\u3001\u5E38\u7528\u64CD\u4F5C\u4EE5\u53CA\u6982\u5FF5"}],["meta",{property:"og:type",content:"article"}],["meta",{property:"og:updated_time",content:"2022-05-16T04:59:52.000Z"}],["meta",{property:"og:locale",content:"zh-CN"}],["meta",{property:"article:modified_time",content:"2022-05-16T04:59:52.000Z"}]]},excerpt:"",headers:[{level:1,title:"\u4E00\u3001\u5E38\u7528\u64CD\u4F5C\u4EE5\u53CA\u6982\u5FF5",slug:"\u4E00\u3001\u5E38\u7528\u64CD\u4F5C\u4EE5\u53CA\u6982\u5FF5",children:[{level:2,title:"\u5FEB\u6377\u952E",slug:"\u5FEB\u6377\u952E",children:[]},{level:2,title:"\u6C42\u52A9",slug:"\u6C42\u52A9",children:[{level:3,title:"1. --help",slug:"_1-help",children:[]},{level:3,title:"2. man",slug:"_2-man",children:[]},{level:3,title:"3. info",slug:"_3-info",children:[]},{level:3,title:"4. doc",slug:"_4-doc",children:[]}]},{level:2,title:"\u5173\u673A",slug:"\u5173\u673A",children:[{level:3,title:"1. who",slug:"_1-who",children:[]},{level:3,title:"2. sync",slug:"_2-sync",children:[]},{level:3,title:"3. shutdown",slug:"_3-shutdown",children:[]}]},{level:2,title:"PATH",slug:"path",children:[]},{level:2,title:"sudo",slug:"sudo",children:[]},{level:2,title:"\u5305\u7BA1\u7406\u5DE5\u5177",slug:"\u5305\u7BA1\u7406\u5DE5\u5177",children:[]},{level:2,title:"\u53D1\u884C\u7248",slug:"\u53D1\u884C\u7248",children:[]},{level:2,title:"VIM \u4E09\u4E2A\u6A21\u5F0F",slug:"vim-\u4E09\u4E2A\u6A21\u5F0F",children:[]},{level:2,title:"GNU",slug:"gnu",children:[]},{level:2,title:"\u5F00\u6E90\u534F\u8BAE",slug:"\u5F00\u6E90\u534F\u8BAE",children:[]}]},{level:1,title:"\u4E8C\u3001\u78C1\u76D8",slug:"\u4E8C\u3001\u78C1\u76D8",children:[{level:2,title:"\u78C1\u76D8\u63A5\u53E3",slug:"\u78C1\u76D8\u63A5\u53E3",children:[{level:3,title:"1. IDE",slug:"_1-ide",children:[]},{level:3,title:"2. SATA",slug:"_2-sata",children:[]},{level:3,title:"3. SCSI",slug:"_3-scsi",children:[]},{level:3,title:"4. SAS",slug:"_4-sas",children:[]}]},{level:2,title:"\u78C1\u76D8\u7684\u6587\u4EF6\u540D",slug:"\u78C1\u76D8\u7684\u6587\u4EF6\u540D",children:[]}]},{level:1,title:"\u4E09\u3001\u5206\u533A",slug:"\u4E09\u3001\u5206\u533A",children:[{level:2,title:"\u5206\u533A\u8868",slug:"\u5206\u533A\u8868",children:[{level:3,title:"1. MBR",slug:"_1-mbr",children:[]},{level:3,title:"2. GPT",slug:"_2-gpt",children:[]}]},{level:2,title:"\u5F00\u673A\u68C0\u6D4B\u7A0B\u5E8F",slug:"\u5F00\u673A\u68C0\u6D4B\u7A0B\u5E8F",children:[{level:3,title:"1. BIOS",slug:"_1-bios",children:[]},{level:3,title:"2. UEFI",slug:"_2-uefi",children:[]}]}]},{level:1,title:"\u56DB\u3001\u6587\u4EF6\u7CFB\u7EDF",slug:"\u56DB\u3001\u6587\u4EF6\u7CFB\u7EDF",children:[{level:2,title:"\u5206\u533A\u4E0E\u6587\u4EF6\u7CFB\u7EDF",slug:"\u5206\u533A\u4E0E\u6587\u4EF6\u7CFB\u7EDF",children:[]},{level:2,title:"\u7EC4\u6210",slug:"\u7EC4\u6210",children:[]},{level:2,title:"\u6587\u4EF6\u8BFB\u53D6",slug:"\u6587\u4EF6\u8BFB\u53D6",children:[]},{level:2,title:"\u78C1\u76D8\u788E\u7247",slug:"\u78C1\u76D8\u788E\u7247",children:[]},{level:2,title:"block",slug:"block",children:[]},{level:2,title:"inode",slug:"inode",children:[]},{level:2,title:"\u76EE\u5F55",slug:"\u76EE\u5F55",children:[]},{level:2,title:"\u65E5\u5FD7",slug:"\u65E5\u5FD7",children:[]},{level:2,title:"\u6302\u8F7D",slug:"\u6302\u8F7D",children:[]},{level:2,title:"\u76EE\u5F55\u914D\u7F6E",slug:"\u76EE\u5F55\u914D\u7F6E",children:[]}]},{level:1,title:"\u4E94\u3001\u6587\u4EF6",slug:"\u4E94\u3001\u6587\u4EF6",children:[{level:2,title:"\u6587\u4EF6\u5C5E\u6027",slug:"\u6587\u4EF6\u5C5E\u6027",children:[]},{level:2,title:"\u6587\u4EF6\u4E0E\u76EE\u5F55\u7684\u57FA\u672C\u64CD\u4F5C",slug:"\u6587\u4EF6\u4E0E\u76EE\u5F55\u7684\u57FA\u672C\u64CD\u4F5C",children:[{level:3,title:"1. ls",slug:"_1-ls",children:[]},{level:3,title:"2. cd",slug:"_2-cd",children:[]},{level:3,title:"3. mkdir",slug:"_3-mkdir",children:[]},{level:3,title:"4. rmdir",slug:"_4-rmdir",children:[]},{level:3,title:"5. touch",slug:"_5-touch",children:[]},{level:3,title:"6. cp",slug:"_6-cp",children:[]},{level:3,title:"7. rm",slug:"_7-rm",children:[]},{level:3,title:"8. mv",slug:"_8-mv",children:[]}]},{level:2,title:"\u4FEE\u6539\u6743\u9650",slug:"\u4FEE\u6539\u6743\u9650",children:[]},{level:2,title:"\u9ED8\u8BA4\u6743\u9650",slug:"\u9ED8\u8BA4\u6743\u9650",children:[]},{level:2,title:"\u76EE\u5F55\u7684\u6743\u9650",slug:"\u76EE\u5F55\u7684\u6743\u9650",children:[]},{level:2,title:"\u94FE\u63A5",slug:"\u94FE\u63A5",children:[{level:3,title:"1. \u5B9E\u4F53\u94FE\u63A5",slug:"_1-\u5B9E\u4F53\u94FE\u63A5",children:[]},{level:3,title:"2. \u7B26\u53F7\u94FE\u63A5",slug:"_2-\u7B26\u53F7\u94FE\u63A5",children:[]}]},{level:2,title:"\u83B7\u53D6\u6587\u4EF6\u5185\u5BB9",slug:"\u83B7\u53D6\u6587\u4EF6\u5185\u5BB9",children:[{level:3,title:"1. cat",slug:"_1-cat",children:[]},{level:3,title:"2. tac",slug:"_2-tac",children:[]},{level:3,title:"3. more",slug:"_3-more",children:[]},{level:3,title:"4. less",slug:"_4-less",children:[]},{level:3,title:"5. head",slug:"_5-head",children:[]},{level:3,title:"6. tail",slug:"_6-tail",children:[]},{level:3,title:"7. od",slug:"_7-od",children:[]}]},{level:2,title:"\u6307\u4EE4\u4E0E\u6587\u4EF6\u641C\u7D22",slug:"\u6307\u4EE4\u4E0E\u6587\u4EF6\u641C\u7D22",children:[{level:3,title:"1. which",slug:"_1-which",children:[]},{level:3,title:"2. whereis",slug:"_2-whereis",children:[]},{level:3,title:"3. locate",slug:"_3-locate",children:[]},{level:3,title:"4. find",slug:"_4-find",children:[]}]}]},{level:1,title:"\u516D\u3001\u538B\u7F29\u4E0E\u6253\u5305",slug:"\u516D\u3001\u538B\u7F29\u4E0E\u6253\u5305",children:[{level:2,title:"\u538B\u7F29\u6587\u4EF6\u540D",slug:"\u538B\u7F29\u6587\u4EF6\u540D",children:[]},{level:2,title:"\u538B\u7F29\u6307\u4EE4",slug:"\u538B\u7F29\u6307\u4EE4",children:[{level:3,title:"1. gzip",slug:"_1-gzip",children:[]},{level:3,title:"2. bzip2",slug:"_2-bzip2",children:[]},{level:3,title:"3. xz",slug:"_3-xz",children:[]}]},{level:2,title:"\u6253\u5305",slug:"\u6253\u5305",children:[]}]},{level:1,title:"\u4E03\u3001Bash",slug:"\u4E03\u3001bash",children:[{level:2,title:"\u7279\u6027",slug:"\u7279\u6027",children:[]},{level:2,title:"\u53D8\u91CF\u64CD\u4F5C",slug:"\u53D8\u91CF\u64CD\u4F5C",children:[]},{level:2,title:"\u6307\u4EE4\u641C\u7D22\u987A\u5E8F",slug:"\u6307\u4EE4\u641C\u7D22\u987A\u5E8F",children:[]},{level:2,title:"\u6570\u636E\u6D41\u91CD\u5B9A\u5411",slug:"\u6570\u636E\u6D41\u91CD\u5B9A\u5411",children:[]}]},{level:1,title:"\u516B\u3001\u7BA1\u9053\u6307\u4EE4",slug:"\u516B\u3001\u7BA1\u9053\u6307\u4EE4",children:[{level:2,title:"\u63D0\u53D6\u6307\u4EE4",slug:"\u63D0\u53D6\u6307\u4EE4",children:[]},{level:2,title:"\u6392\u5E8F\u6307\u4EE4",slug:"\u6392\u5E8F\u6307\u4EE4",children:[]},{level:2,title:"\u53CC\u5411\u8F93\u51FA\u91CD\u5B9A\u5411",slug:"\u53CC\u5411\u8F93\u51FA\u91CD\u5B9A\u5411",children:[]},{level:2,title:"\u5B57\u7B26\u8F6C\u6362\u6307\u4EE4",slug:"\u5B57\u7B26\u8F6C\u6362\u6307\u4EE4",children:[]},{level:2,title:"\u5206\u533A\u6307\u4EE4",slug:"\u5206\u533A\u6307\u4EE4",children:[]}]},{level:1,title:"\u4E5D\u3001\u6B63\u5219\u8868\u8FBE\u5F0F",slug:"\u4E5D\u3001\u6B63\u5219\u8868\u8FBE\u5F0F",children:[{level:2,title:"grep",slug:"grep",children:[]},{level:2,title:"printf",slug:"printf",children:[]},{level:2,title:"awk",slug:"awk",children:[]}]},{level:1,title:"\u5341\u3001\u8FDB\u7A0B\u7BA1\u7406",slug:"\u5341\u3001\u8FDB\u7A0B\u7BA1\u7406",children:[{level:2,title:"\u67E5\u770B\u8FDB\u7A0B",slug:"\u67E5\u770B\u8FDB\u7A0B",children:[{level:3,title:"1. ps",slug:"_1-ps",children:[]},{level:3,title:"2. pstree",slug:"_2-pstree",children:[]},{level:3,title:"3. top",slug:"_3-top",children:[]},{level:3,title:"4. netstat",slug:"_4-netstat",children:[]}]},{level:2,title:"\u8FDB\u7A0B\u72B6\u6001",slug:"\u8FDB\u7A0B\u72B6\u6001",children:[]},{level:2,title:"SIGCHLD",slug:"sigchld",children:[]},{level:2,title:"wait()",slug:"wait",children:[]},{level:2,title:"waitpid()",slug:"waitpid",children:[]},{level:2,title:"\u5B64\u513F\u8FDB\u7A0B",slug:"\u5B64\u513F\u8FDB\u7A0B",children:[]},{level:2,title:"\u50F5\u5C38\u8FDB\u7A0B",slug:"\u50F5\u5C38\u8FDB\u7A0B",children:[]}]},{level:1,title:"\u53C2\u8003\u8D44\u6599",slug:"\u53C2\u8003\u8D44\u6599",children:[]}],git:{createdTime:1652677192e3,updatedTime:1652677192e3,contributors:[{name:"chenwei.tjw",email:"chenwei.tjw@alibaba-inc.com",commits:1}]},readingTime:{minutes:34.98,words:10495},filePathRelative:"notes/\u64CD\u4F5C\u7CFB\u7EDF/Linux.md"};export{l as data};
