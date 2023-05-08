import{_ as e}from"./plugin-vue_export-helper.21dcd24c.js";import{f as o}from"./app.e9c8698e.js";var t="/cs-way/assets/mk-2020-07-14-10-17-29.a7cbc9e8.png",n="/cs-way/assets/mk-2020-07-14-09-40-25.dbab19b5.png";const a={},i=o('<ul><li><a href="#%E4%BB%8B%E7%BB%8D">\u4ECB\u7ECD</a><ul><li><a href="#netty%E4%BC%98%E5%8A%BF">Netty\u4F18\u52BF</a></li><li><a href="#%E6%A0%B8%E5%BF%83%E7%BB%84%E4%BB%B6">\u6838\u5FC3\u7EC4\u4EF6</a></li><li><a href="#%E7%BA%BF%E7%A8%8B%E6%A8%A1%E5%9E%8B">\u7EBF\u7A0B\u6A21\u578B</a></li></ul></li></ul><h1 id="\u4ECB\u7ECD" tabindex="-1"><a class="header-anchor" href="#\u4ECB\u7ECD" aria-hidden="true">#</a> \u4ECB\u7ECD</h1><p>Netty \u662F\u4E00\u4E2A\u5229\u7528 Java \u7684\u9AD8\u7EA7\u7F51\u7EDC\u7684\u80FD\u529B\uFF0C\u9690\u85CF\u5176\u80CC\u540E\u7684\u590D\u6742\u6027\u800C\u63D0\u4F9B\u4E00\u4E2A\u6613\u4E8E\u4F7F\u7528\u7684 API \u7684\u5BA2\u6237\u7AEF/\u670D\u52A1\u5668\u6846\u67B6\u3002</p><p>Netty\u662F\u4E00\u4E2A\u5F02\u6B65\u3001\u57FA\u4E8E\u4E8B\u4EF6\u9A71\u52A8\u7684\u7F51\u7EDC\u5E94\u7528\u7A0B\u5E8F\u6846\u67B6\uFF0C\u5176\u5BF9 Java NIO\u8FDB\u884C\u4E86\u5C01\u88C5\uFF0C\u5927\u5927\u7B80\u5316\u4E86 TCP \u6216\u8005 UDP \u670D\u52A1\u5668\u7684\u7F51\u7EDC\u7F16\u7A0B\u3002</p><h2 id="netty\u4F18\u52BF" tabindex="-1"><a class="header-anchor" href="#netty\u4F18\u52BF" aria-hidden="true">#</a> Netty\u4F18\u52BF</h2><ul><li>\u5E76\u53D1\u9AD8</li><li>\u4F20\u8F93\u5FEB</li><li>\u5C01\u88C5\u597D</li></ul><h2 id="\u6838\u5FC3\u7EC4\u4EF6" tabindex="-1"><a class="header-anchor" href="#\u6838\u5FC3\u7EC4\u4EF6" aria-hidden="true">#</a> \u6838\u5FC3\u7EC4\u4EF6</h2><ul><li>Bootstrap\u548CServerBootstrap\uFF1ANetty\u5E94\u7528\u7A0B\u5E8F\u901A\u8FC7\u8BBE\u7F6Ebootstrap\u5F15\u5BFC\u7C7B\u6765\u5B8C\u6210\uFF0C\u8BE5\u7C7B\u63D0\u4F9B\u4E86\u4E00\u4E2A\u7528\u4E8E\u5E94\u7528\u7A0B\u5E8F\u7F51\u7EDC\u5C42\u914D\u7F6E\u7684\u5BB9\u5668\u3002Bootstrap\u670D\u52A1\u7AEF\u7684\u662FServerBootstrap\uFF0C\u5BA2\u6237\u7AEF\u7684\u662FBootstrap\u3002</li><li>Channel\uFF1ANetty \u4E2D\u7684\u63A5\u53E3 Channel \u5B9A\u4E49\u4E86\u4E0E socket \u4E30\u5BCC\u4EA4\u4E92\u7684\u64CD\u4F5C\u96C6\uFF1Abind, close, config, connect, isActive, isOpen, isWritable, read, write \u7B49\u7B49\u3002</li><li>ChannelHandler\uFF1AChannelHandler \u652F\u6301\u5F88\u591A\u534F\u8BAE\uFF0C\u5E76\u4E14\u63D0\u4F9B\u7528\u4E8E\u6570\u636E\u5904\u7406\u7684\u5BB9\u5668\uFF0CChannelHandler\u7531\u7279\u5B9A\u4E8B\u4EF6\u89E6\u53D1\uFF0C \u5E38\u7528\u7684\u4E00\u4E2A\u63A5\u53E3\u662FChannelInboundHandler\uFF0C\u8BE5\u7C7B\u578B\u5904\u7406\u5165\u7AD9\u8BFB\u6570\u636E\uFF08socket\u8BFB\u4E8B\u4EF6\uFF09\u3002</li><li>ChannelPipeline\uFF1AChannelPipeline \u63D0\u4F9B\u4E86\u4E00\u4E2A\u5BB9\u5668\u7ED9 ChannelHandler \u94FE\u5E76\u63D0\u4F9B\u4E86\u4E00\u4E2AAPI \u7528\u4E8E\u7BA1\u7406\u6CBF\u7740\u94FE\u5165\u7AD9\u548C\u51FA\u7AD9\u4E8B\u4EF6\u7684\u6D41\u52A8\u3002\u6BCF\u4E2A Channel \u90FD\u6709\u81EA\u5DF1\u7684ChannelPipeline\uFF0C\u5F53 Channel \u521B\u5EFA\u65F6\u81EA\u52A8\u521B\u5EFA\u7684</li><li>EventLoop\uFF1AEventLoop \u7528\u4E8E\u5904\u7406 Channel \u7684 I/O \u64CD\u4F5C\u3002\u4E00\u4E2A\u5355\u4E00\u7684 EventLoop\u901A\u5E38\u4F1A\u5904\u7406\u591A\u4E2A Channel \u4E8B\u4EF6\u3002\u4E00\u4E2A EventLoopGroup \u53EF\u4EE5\u542B\u6709\u591A\u4E8E\u4E00\u4E2A\u7684 EventLoop \u548C \u63D0\u4F9B\u4E86\u4E00\u79CD\u8FED\u4EE3\u7528\u4E8E\u68C0\u7D22\u6E05\u5355\u4E2D\u7684\u4E0B\u4E00\u4E2A\u3002</li><li>ChannelFuture\uFF1ANetty \u6240\u6709\u7684 I/O \u64CD\u4F5C\u90FD\u662F\u5F02\u6B65\u3002\u56E0\u4E3A\u4E00\u4E2A\u64CD\u4F5C\u53EF\u80FD\u65E0\u6CD5\u7ACB\u5373\u8FD4\u56DE\uFF0C\u6211\u4EEC\u9700\u8981\u6709\u4E00\u79CD\u65B9\u6CD5\u5728\u4EE5\u540E\u83B7\u53D6\u5B83\u7684\u7ED3\u679C\u3002\u51FA\u4E8E\u8FD9\u4E2A\u76EE\u7684\uFF0CNetty \u63D0\u4F9B\u4E86\u63A5\u53E3 ChannelFuture,\u5B83\u7684 addListener \u65B9\u6CD5</li></ul><p><img src="'+t+'" alt="" loading="lazy"></p><p>Netty \u662F\u4E00\u4E2A\u975E\u963B\u585E\u3001\u4E8B\u4EF6\u9A71\u52A8\u7684\u7F51\u7EDC\u6846\u67B6\u3002Netty \u5B9E\u9645\u4E0A\u662F\u4F7F\u7528 Threads\uFF08 \u591A\u7EBF\u7A0B\uFF09 \u5904\u7406 I/O\u4E8B\u4EF6\u7684\uFF0C\u5BF9\u4E8E\u719F\u6089\u591A\u7EBF\u7A0B\u7F16\u7A0B\u7684\u8BFB\u8005\u53EF\u80FD\u4F1A\u9700\u8981\u5173\u6CE8\u540C\u6B65\u4EE3\u7801\u3002\u8FD9\u6837\u7684\u65B9\u5F0F\u4E0D\u597D\uFF0C\u56E0\u4E3A\u540C\u6B65\u4F1A\u5F71\u54CD\u7A0B\u5E8F\u7684\u6027\u80FD\uFF0CNetty \u7684\u8BBE\u8BA1\u4FDD\u8BC1\u7A0B\u5E8F\u5904\u7406\u4E8B\u4EF6\u4E0D\u4F1A\u6709\u540C\u6B65\u3002\u56E0\u4E3A\u67D0\u4E2AChannel\u4E8B\u4EF6\u662F\u88AB\u6DFB\u52A0\u5230\u4E00\u4E2AEventLoop\u4E2D\u7684\uFF0C\u4EE5\u540E\u8BE5Channel\u4E8B\u4EF6\u90FD\u662F\u7531\u8BE5EventLoop\u6765\u5904\u7406\u7684\uFF0C\u800CEventLoop\u662F\u4E00\u4E2A\u7EBF\u7A0B\u6765\u5904\u7406\u7684\uFF0C\u4E5F\u5C31\u662F\u8BF4Netty\u4E0D\u9700\u8981\u540C\u6B65IO\u64CD\u4F5C\uFF0CEventLoop\u4E0EEventLoopGroup\u7684\u5173\u7CFB\u53EF\u4EE5\u7406\u89E3\u4E3A\u7EBF\u7A0B\u4E0E\u7EBF\u7A0B\u6C60\u7684\u5173\u7CFB\u4E00\u6837\u3002</p><h2 id="\u7EBF\u7A0B\u6A21\u578B" tabindex="-1"><a class="header-anchor" href="#\u7EBF\u7A0B\u6A21\u578B" aria-hidden="true">#</a> \u7EBF\u7A0B\u6A21\u578B</h2><p><img src="'+n+'" alt="" loading="lazy"></p><p>\u4E0A\u56FE\u4E0B\u4FA7\u4E3ANetty Server\u7AEF,\u5F53NettyServer\u542F\u52A8\u65F6\u5019\u4F1A\u521B\u5EFA\u4E24\u4E2ANioEventLoopGroup\u7EBF\u7A0B\u6C60\u7EC4\uFF0C\u5176\u4E2Dboss\u7EC4\u7528\u6765\u63A5\u53D7\u5BA2\u6237\u7AEF\u53D1\u6765\u7684\u8FDE\u63A5\uFF0Cworker\u7EC4\u5219\u8D1F\u8D23\u5BF9\u5B8C\u6210TCP\u4E09\u6B21\u63E1\u624B\u7684\u8FDE\u63A5\u8FDB\u884C\u5904\u7406\uFF1B\u5982\u4E0A\u56FE\u6BCF\u4E2ANioEventLoopGroup\u91CC\u9762\u5305\u542B\u4E86\u591A\u4E2ANioEventLoop\uFF0C\u6BCF\u4E2ANioEventLoop\u4E2D\u5305\u542B\u4E86\u4E00\u4E2ANIO Selector\u3001\u4E00\u4E2A\u961F\u5217\u3001\u4E00\u4E2A\u7EBF\u7A0B\uFF1B\u5176\u4E2D\u7EBF\u7A0B\u7528\u6765\u505A\u8F6E\u8BE2\u6CE8\u518C\u5230Selector\u4E0A\u7684Channel\u7684\u8BFB\u5199\u4E8B\u4EF6\u548C\u5BF9\u6295\u9012\u5230\u961F\u5217\u91CC\u9762\u7684\u4E8B\u4EF6\u8FDB\u884C\u5904\u7406\u3002</p><p>\u5F53NettyServer\u542F\u52A8\u65F6\u5019\u4F1A\u6CE8\u518C\u76D1\u542C\u5957\u63A5\u5B57\u901A\u9053NioServerSocketChannel\u5230boss\u7EBF\u7A0B\u6C60\u7EC4\u4E2D\u7684\u67D0\u4E00\u4E2ANioEventLoop\u7BA1\u7406\u7684Selector\u4E0A\uFF0C\u7136\u540E\u5176\u5BF9\u5E94\u7684\u7EBF\u7A0B\u5219\u4F1A\u8D1F\u8D23\u8F6E\u8BE2\u8BE5\u76D1\u542C\u5957\u63A5\u5B57\u4E0A\u7684\u8FDE\u63A5\u8BF7\u6C42\uFF1B\u5F53\u5BA2\u6237\u7AEF\u53D1\u6765\u4E00\u4E2A\u8FDE\u63A5\u8BF7\u6C42\u65F6\u5019\uFF0Cboss\u7EBF\u7A0B\u6C60\u7EC4\u4E2D\u6CE8\u518C\u4E86\u76D1\u542C\u5957\u63A5\u5B57\u7684NioEventLoop\u4E2D\u7684Selector\u4F1A\u8BFB\u53D6\u8BFB\u53D6\u5B8C\u6210\u4E86TCP\u4E09\u6B21\u63E1\u624B\u7684\u8BF7\u6C42\uFF0C\u7136\u540E\u521B\u5EFA\u5BF9\u5E94\u7684\u8FDE\u63A5\u5957\u63A5\u5B57\u901A\u9053NioSocketChannel\uFF0C\u7136\u540E\u628A\u5176\u6CE8\u518C\u5230worker\u7EBF\u7A0B\u6C60\u7EC4\u4E2D\u7684\u67D0\u4E00\u4E2ANioEventLoop\u4E2D\u7BA1\u7406\u7684\u4E00\u4E2ANIO Selector\u4E0A\uFF0C\u7136\u540E\u8BE5\u8FDE\u63A5\u5957\u63A5\u5B57\u901A\u9053NioSocketChannel\u4E0A\u7684\u6240\u6709\u8BFB\u5199\u4E8B\u4EF6\u90FD\u7531\u8BE5NioEventLoop\u7BA1\u7406\u3002\u5F53\u5BA2\u6237\u7AEF\u53D1\u6765\u591A\u4E2A\u8FDE\u63A5\u65F6\u5019\uFF0CNettyServer\u7AEF\u5219\u4F1A\u521B\u5EFA\u591A\u4E2ANioSocketChannel\uFF0C\u800Cworker\u7EBF\u7A0B\u6C60\u7EC4\u4E2D\u7684NioEventLoop\u662F\u6709\u4E2A\u6570\u9650\u5236\u7684\uFF0C\u6240\u4EE5Netty\u6709\u4E00\u5B9A\u7684\u7B56\u7565\u628A\u5F88\u591ANioSocketChannel\u6CE8\u518C\u5230\u4E0D\u540C\u7684NioEventLoop\u4E0A\uFF0C\u4E5F\u5C31\u662F\u6BCF\u4E2ANioEventLoop\u4E2D\u4F1A\u7BA1\u7406\u597D\u591A\u5BA2\u6237\u7AEF\u53D1\u6765\u7684\u8FDE\u63A5\uFF0C\u7136\u540E\u901A\u8FC7\u5FAA\u73AF\u8F6E\u8BE2\u5904\u7406\u6BCF\u4E2A\u8FDE\u63A5\u7684\u8BFB\u5199\u4E8B\u4EF6\u3002</p><p>\u5982\u4E0A\u56FE\u4E0A\u4FA7\u90E8\u5206\u4E3ANetty Client\u90E8\u5206\uFF0C\u5F53NettyClient\u542F\u52A8\u65F6\u5019\u4F1A\u521B\u5EFA\u4E00\u4E2ANioEventLoopGroup\uFF0C\u7528\u6765\u53D1\u8D77\u8BF7\u6C42\u5E76\u5BF9\u5EFA\u7ACBTCP\u4E09\u6B21\u8FDE\u63A5\u7684\u5957\u63A5\u5B57\u7684\u8BFB\u5199\u4E8B\u4EF6\u8FDB\u884C\u5904\u7406\u3002\u5F53\u8C03\u7528Bootstrap\u7684connect\u65B9\u6CD5\u53D1\u8D77\u8FDE\u63A5\u8BF7\u6C42\u540E\u5185\u90E8\u4F1A\u521B\u5EFA\u4E00\u4E2ANioSocketChannel\u7528\u6765\u4EE3\u8868\u8BE5\u8BF7\u6C42\uFF0C\u5E76\u4E14\u4F1A\u628A\u8BE5NioSocketChannel\u6CE8\u518C\u5230NioSocketChannel\u7BA1\u7406\u7684\u67D0\u4E2ANioEventLoop\u7684Selector\u4E0A\uFF0C\u7136\u540E\u8BE5NioEventLoop\u7684\u8BFB\u5199\u4E8B\u4EF6\u90FD\u6709\u8BE5NioEventLoop\u8D1F\u8D23\u5904\u7406\u3002</p><p>Netty\u4E4B\u6240\u4EE5\u8BF4\u662F\u5F02\u6B65\u975E\u963B\u585E\u7F51\u7EDC\u6846\u67B6\u662F\u56E0\u4E3A\u901A\u8FC7NioSocketChannel\u7684write\u7CFB\u5217\u65B9\u6CD5\u5411\u8FDE\u63A5\u91CC\u9762\u5199\u5165\u6570\u636E\u65F6\u5019\u662F\u975E\u963B\u585E\u7684\uFF0C\u9A6C\u4E0A\u4F1A\u8FD4\u56DE\u7684\uFF0C\u5373\u4F7F\u8C03\u7528\u5199\u5165\u7684\u7EBF\u7A0B\u662F\u6211\u4EEC\u7684\u4E1A\u52A1\u7EBF\u7A0B\uFF0C\u8FD9\u662FNetty\u901A\u8FC7\u5728ChannelPipeline\u4E2D\u5224\u65AD\u8C03\u7528NioSocketChannel\u7684write\u7684\u8C03\u7528\u7EBF\u7A0B\u662F\u4E0D\u662F\u5176\u5BF9\u5E94\u7684NioEventLoop\u4E2D\u7684\u7EBF\u7A0B\u6765\u5B9E\u73B0\u7684\uFF0C\u5982\u679C\u53D1\u73B0\u4E0D\u662F\u5219\u4F1A\u628A\u5199\u5165\u8BF7\u6C42\u5C01\u88C5\u4E3AWriteTask\u6295\u9012\u5230\u5176\u5BF9\u5E94\u7684NioEventLoop\u4E2D\u7684\u961F\u5217\u91CC\u9762\uFF0C\u7136\u540E\u7B49\u5176\u5BF9\u5E94\u7684NioEventLoop\u4E2D\u7684\u7EBF\u7A0B\u8F6E\u8BE2\u8FDE\u63A5\u5957\u63A5\u5B57\u7684\u8BFB\u5199\u4E8B\u4EF6\u65F6\u5019\u634E\u5E26\u4ECE\u961F\u5217\u91CC\u9762\u53D6\u51FA\u6765\u6267\u884C\uFF1B\u603B\u7ED3\u8BF4\u5C31\u662F\u6BCF\u4E2ANioSocketChannel\u5BF9\u5E94\u7684\u8BFB\u5199\u4E8B\u4EF6\u90FD\u662F\u5728\u5176\u5BF9\u5E94\u7684NioEventLoop\u7BA1\u7406\u7684\u5355\u7EBF\u7A0B\u5185\u6267\u884C\uFF0C\u5BF9\u540C\u4E00\u4E2ANioSocketChannel\u4E0D\u5B58\u5728\u5E76\u53D1\u8BFB\u5199\uFF0C\u6240\u4EE5\u65E0\u9700\u52A0\u9501\u5904\u7406\u3002</p><p>\u53E6\u5916\u5F53\u4ECENioSocketChannel\u4E2D\u8BFB\u53D6\u6570\u636E\u65F6\u5019\uFF0C\u5E76\u4E0D\u662F\u4F7F\u7528\u4E1A\u52A1\u7EBF\u7A0B\u6765\u963B\u585E\u7B49\u5F85\uFF0C\u800C\u662F\u7B49NioEventLoop\u4E2D\u7684IO\u8F6E\u8BE2\u7EBF\u7A0B\u53D1\u73B0Selector\u4E0A\u6709\u6570\u636E\u5C31\u7EEA\u65F6\u5019\uFF0C\u901A\u8FC7\u4E8B\u4EF6\u901A\u77E5\u65B9\u5F0F\u6765\u901A\u77E5\u6211\u4EEC\u4E1A\u52A1\u6570\u636E\u5DF2\u7ECF\u5C31\u7EEA\uFF0C\u53EF\u4EE5\u6765\u8BFB\u53D6\u5E76\u5904\u7406\u4E86\u3002</p><p>\u603B\u7ED3\u4E00\u53E5\u8BDD\u5C31\u662F\u4F7F\u7528Netty\u6846\u67B6\u8FDB\u884C\u7F51\u7EDC\u901A\u4FE1\u65F6\u5019\uFF0C\u5F53\u6211\u4EEC\u53D1\u8D77\u8BF7\u6C42\u540E\u8BF7\u6C42\u4F1A\u9A6C\u4E0A\u8FD4\u56DE\uFF0C\u800C\u4E0D\u4F1A\u963B\u585E\u6211\u4EEC\u7684\u4E1A\u52A1\u8C03\u7528\u7EBF\u7A0B\uFF1B\u5982\u679C\u6211\u4EEC\u60F3\u8981\u83B7\u53D6\u8BF7\u6C42\u7684\u54CD\u5E94\u7ED3\u679C\uFF0C\u4E5F\u4E0D\u9700\u8981\u4E1A\u52A1\u8C03\u7528\u7EBF\u7A0B\u4F7F\u7528\u963B\u585E\u7684\u65B9\u5F0F\u6765\u7B49\u5F85\uFF0C\u800C\u662F\u5F53\u54CD\u5E94\u7ED3\u679C\u51FA\u6765\u65F6\u5019\u4F7F\u7528IO\u7EBF\u7A0B\u5F02\u6B65\u901A\u77E5\u4E1A\u52A1\u7684\u65B9\u5F0F\uFF0C\u53EF\u77E5\u5728\u6574\u4E2A\u8BF7\u6C42-\u54CD\u5E94\u8FC7\u7A0B\u4E2D\u4E1A\u52A1\u7EBF\u7A0B\u4E0D\u4F1A\u7531\u4E8E\u963B\u585E\u7B49\u5F85\u800C\u4E0D\u80FD\u5E72\u5176\u4ED6\u4E8B\u60C5\u3002</p>',18);function l(r,p){return i}var c=e(a,[["render",l],["__file","Netty.html.vue"]]);export{c as default};