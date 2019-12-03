package com.example.douban.app.data.entity.detail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailBean {


    /**
     * rating : {"max":10,"average":7.3,"details":{"1":160,"3":9112,"2":1304,"5":3767,"4":8965},"stars":"40","min":0}
     * reviews_count : 1120
     * videos : []
     * wish_count : 86098
     * original_title : Frozen II
     * blooper_urls : ["http://vt1.doubanio.com/201912031059/787737cf1d41f904e615c45873da2984/view/movie/M/302550780.mp4","http://vt1.doubanio.com/201912031059/bd54628dac8a9ee261d6358b8983f8ac/view/movie/M/302550099.mp4","http://vt1.doubanio.com/201912031059/8b81c63567c5780dbf464ac5d87660fd/view/movie/M/302550908.mp4","http://vt1.doubanio.com/201912031059/c60614f4b373cefce2bf2bcc0810a087/view/movie/M/302530486.mp4"]
     * collect_count : 152014
     * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2572847101.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2572847101.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2572847101.webp"}
     * douban_site :
     * year : 2019
     * popular_comments : [{"rating":{"max":5,"value":3,"min":0},"useful_count":2651,"author":{"uid":"lingrui1995","avatar":"https://img1.doubanio.com/icon/u63688511-18.jpg","signature":"一个影迷","alt":"https://www.douban.com/people/lingrui1995/","id":"63688511","name":"凌睿"},"subject_id":"25887288","content":"当皮克斯动画越来越有想象力的同时，没想到迪士尼动画已经变得如此平庸、吃老本、不求上进。\n的确技术更先进了，画面更精美了，但是内核和剧本却严重倒退，华而不实，形式大于内容。\n第一部中对女性力量的赞美、女性不应该被爱情和婚姻定义、不需要王子也能做公主、正视自己的独特之处而不在乎他人的看法\u2026\u2026在第二部通通荡然无存，竟然变成了一部环保片。\n解决所有问题的办法，竟然是毁掉大坝。迪士尼动画什么时候变得这么说教了？\n又双叒叕是两个王国握手言和的大团圆结局，好像什么都没发生过一样。俗套得不能再俗套了，甚至上个月同属迪士尼的《沉睡魔咒2》刚刚才拍过。\n毫无悬念本片票房将大爆，因为它拍得太工整、太华丽了，没有任何问题。\n但是这种打安全牌的合家欢电影已经看得太多了，我还是怀念以前能看到各种风格、各种类型的电影的日子。","created_at":"2019-11-22 13:22:29","id":"2051209299"},{"rating":{"max":5,"value":4,"min":0},"useful_count":4972,"author":{"uid":"yingpingduli","avatar":"https://img3.doubanio.com/icon/u66469764-153.jpg","signature":"","alt":"https://www.douban.com/people/yingpingduli/","id":"66469764","name":"刘小流"},"subject_id":"25887288","content":"艾莎看到曾经唱《let it go》的自己害臊的样子，多像文青一不小心看到了自己的当年\u2026\u2026","created_at":"2019-11-22 02:00:02","id":"1614529312"},{"rating":{"max":5,"value":3,"min":0},"useful_count":1764,"author":{"uid":"162588215","avatar":"https://img1.doubanio.com/icon/u162588215-18.jpg","signature":"","alt":"https://www.douban.com/people/162588215/","id":"162588215","name":"上山打恼虎"},"subject_id":"25887288","content":"安娜你醒醒！！！醒醒！！你爱的一直是你姐！！你要勇敢起来！！面对你的性取向！！（妙蛙种子全场最可爱！！）","created_at":"2019-11-22 15:36:38","id":"2051357884"},{"rating":{"max":5,"value":2,"min":0},"useful_count":410,"author":{"uid":"55842929","avatar":"https://img3.doubanio.com/icon/u55842929-2.jpg","signature":"","alt":"https://www.douban.com/people/55842929/","id":"55842929","name":"谢明宏"},"subject_id":"25887288","content":"我突然想起了《大话西游》：你看，现在是姐姐救妹妹，一会儿就是妹妹救姐姐。","created_at":"2019-11-22 13:41:29","id":"2051229789"}]
     * alt : https://movie.douban.com/subject/25887288/
     * id : 25887288
     * mobile_url : https://movie.douban.com/subject/25887288/mobile
     * photos_count : 517
     * pubdate : 2019-11-22
     * title : 冰雪奇缘2
     * do_count : null
     * has_video : false
     * share_url : https://m.douban.com/movie/subject/25887288
     * seasons_count : null
     * languages : ["英语"]
     * schedule_url : https://movie.douban.com/subject/25887288/cinema/
     * writers : [{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392548591.79.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392548591.79.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392548591.79.webp"},"name_en":"Jennifer Lee","name":"珍妮弗·李","alt":"https://movie.douban.com/celebrity/1335174/","id":"1335174"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48399.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48399.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48399.webp"},"name_en":"Chris Buck","name":"克里斯·巴克","alt":"https://movie.douban.com/celebrity/1279552/","id":"1279552"},{"avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"Marc Smith","name":"马克·史密斯","alt":"https://movie.douban.com/celebrity/1427027/","id":"1427027"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1505787442.15.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1505787442.15.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1505787442.15.webp"},"name_en":"Kristen Anderson-Lopez","name":"克里斯汀·安德森·洛佩兹","alt":"https://movie.douban.com/celebrity/1337970/","id":"1337970"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1396846351.28.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1396846351.28.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1396846351.28.webp"},"name_en":"Robert Lopez","name":"罗伯特·洛佩兹","alt":"https://movie.douban.com/celebrity/1337971/","id":"1337971"}]
     * pubdates : ["2019-11-22(美国)","2019-11-22(中国大陆)"]
     * website :
     * tags : ["迪士尼","动画","童话","美国","2019","音乐","奇幻","魔幻","女性","冒险"]
     * has_schedule : true
     * durations : ["104分钟"]
     * genres : ["喜剧","动画","冒险"]
     * collection : null
     * trailers : [{"medium":"https://img3.doubanio.com/img/trailer/medium/2569586491.jpg?","title":"中国预告片 (中文字幕)","subject_id":"25887288","alt":"https://movie.douban.com/trailer/253176/","small":"https://img3.doubanio.com/img/trailer/small/2569586491.jpg?","resource_url":"http://vt1.doubanio.com/201912031059/2bf26411063ef0f5adbd38e8abef0157/view/movie/M/302530176.mp4","id":"253176"},{"medium":"https://img1.doubanio.com/img/trailer/medium/2572847417.jpg?","title":"中国预告片：定档版 (中文字幕)","subject_id":"25887288","alt":"https://movie.douban.com/trailer/254873/","small":"https://img1.doubanio.com/img/trailer/small/2572847417.jpg?","resource_url":"http://vt1.doubanio.com/201912031059/a18b0f2b7e5d6dbce7f3ee9646eb7ef0/view/movie/M/302540873.mp4","id":"254873"},{"medium":"https://img3.doubanio.com/img/trailer/medium/2559336042.jpg?","title":"中国预告片 (中文字幕)","subject_id":"25887288","alt":"https://movie.douban.com/trailer/248379/","small":"https://img3.doubanio.com/img/trailer/small/2559336042.jpg?","resource_url":"http://vt1.doubanio.com/201912031059/76002b71edd25d6199d7306942bedfcb/view/movie/M/302480379.mp4","id":"248379"},{"medium":"https://img3.doubanio.com/img/trailer/medium/2559323120.jpg?","title":"预告片","subject_id":"25887288","alt":"https://movie.douban.com/trailer/248378/","small":"https://img3.doubanio.com/img/trailer/small/2559323120.jpg?","resource_url":"http://vt1.doubanio.com/201912031059/a3424e15244e03ab7b220b8b141f8366/view/movie/M/302480378.mp4","id":"248378"}]
     * episodes_count : null
     * trailer_urls : ["http://vt1.doubanio.com/201912031059/2bf26411063ef0f5adbd38e8abef0157/view/movie/M/302530176.mp4","http://vt1.doubanio.com/201912031059/a18b0f2b7e5d6dbce7f3ee9646eb7ef0/view/movie/M/302540873.mp4","http://vt1.doubanio.com/201912031059/76002b71edd25d6199d7306942bedfcb/view/movie/M/302480379.mp4","http://vt1.doubanio.com/201912031059/a3424e15244e03ab7b220b8b141f8366/view/movie/M/302480378.mp4"]
     * has_ticket : true
     * bloopers : [{"medium":"https://img3.doubanio.com/img/trailer/medium/2574683481.jpg?1574234809","title":"花絮","subject_id":"25887288","alt":"https://movie.douban.com/trailer/255780/","small":"https://img3.doubanio.com/img/trailer/small/2574683481.jpg?1574234809","resource_url":"http://vt1.doubanio.com/201912031059/787737cf1d41f904e615c45873da2984/view/movie/M/302550780.mp4","id":"255780"},{"medium":"https://img3.doubanio.com/img/trailer/medium/2573315485.jpg?1572866684","title":"花絮：卡司特辑","subject_id":"25887288","alt":"https://movie.douban.com/trailer/255099/","small":"https://img3.doubanio.com/img/trailer/small/2573315485.jpg?1572866684","resource_url":"http://vt1.doubanio.com/201912031059/bd54628dac8a9ee261d6358b8983f8ac/view/movie/M/302550099.mp4","id":"255099"},{"medium":"https://img3.doubanio.com/img/trailer/medium/2574923651.jpg?1574689640","title":"MV：Panic! At The Disco - 《Into the Unknown》","subject_id":"25887288","alt":"https://movie.douban.com/trailer/255908/","small":"https://img3.doubanio.com/img/trailer/small/2574923651.jpg?1574689640","resource_url":"http://vt1.doubanio.com/201912031059/8b81c63567c5780dbf464ac5d87660fd/view/movie/M/302550908.mp4","id":"255908"},{"medium":"https://img1.doubanio.com/img/trailer/medium/2570155299.jpg?","title":"MV：《Into The Unknown》","subject_id":"25887288","alt":"https://movie.douban.com/trailer/253486/","small":"https://img1.doubanio.com/img/trailer/small/2570155299.jpg?","resource_url":"http://vt1.doubanio.com/201912031059/c60614f4b373cefce2bf2bcc0810a087/view/movie/M/302530486.mp4","id":"253486"}]
     * clip_urls : ["http://vt1.doubanio.com/201912031059/31b13508d082163c65ad26b44dd8b6a2/view/movie/M/302550782.mp4","http://vt1.doubanio.com/201912031059/f04e40183ea132bdac81e8daebbf1247/view/movie/M/302550730.mp4","http://vt1.doubanio.com/201912031059/ee5d60549876d3071d042b649d712816/view/movie/M/302550733.mp4","http://vt1.doubanio.com/201912031059/1fa50ef21f5e6d16253bf502e33a015f/view/movie/M/302550734.mp4"]
     * current_season : null
     * casts : [{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395152016.01.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395152016.01.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395152016.01.webp"},"name_en":"Kristen Bell","name":"克里斯汀·贝尔","alt":"https://movie.douban.com/celebrity/1031240/","id":"1031240"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p22400.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p22400.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p22400.webp"},"name_en":"Idina Menzel","name":"伊迪娜·门泽尔","alt":"https://movie.douban.com/celebrity/1116746/","id":"1116746"},{"avatars":{"small":"https://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392108916.14.webp","large":"https://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392108916.14.webp","medium":"https://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392108916.14.webp"},"name_en":"Josh Gad","name":"乔什·加德","alt":"https://movie.douban.com/celebrity/1305235/","id":"1305235"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391831466.59.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391831466.59.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391831466.59.webp"},"name_en":"Jonathan Groff","name":"乔纳森·格罗夫","alt":"https://movie.douban.com/celebrity/1000002/","id":"1000002"}]
     * countries : ["美国"]
     * mainland_pubdate : 2019-11-22
     * photos : [{"thumb":"https://img1.doubanio.com/view/photo/m/public/p2569630078.webp","image":"https://img1.doubanio.com/view/photo/l/public/p2569630078.webp","cover":"https://img1.doubanio.com/view/photo/sqs/public/p2569630078.webp","alt":"https://movie.douban.com/photos/photo/2569630078/","id":"2569630078","icon":"https://img1.doubanio.com/view/photo/s/public/p2569630078.webp"},{"thumb":"https://img9.doubanio.com/view/photo/m/public/p2548021474.webp","image":"https://img9.doubanio.com/view/photo/l/public/p2548021474.webp","cover":"https://img9.doubanio.com/view/photo/sqs/public/p2548021474.webp","alt":"https://movie.douban.com/photos/photo/2548021474/","id":"2548021474","icon":"https://img9.doubanio.com/view/photo/s/public/p2548021474.webp"},{"thumb":"https://img3.doubanio.com/view/photo/m/public/p2571512003.webp","image":"https://img3.doubanio.com/view/photo/l/public/p2571512003.webp","cover":"https://img3.doubanio.com/view/photo/sqs/public/p2571512003.webp","alt":"https://movie.douban.com/photos/photo/2571512003/","id":"2571512003","icon":"https://img3.doubanio.com/view/photo/s/public/p2571512003.webp"},{"thumb":"https://img1.doubanio.com/view/photo/m/public/p2559332018.webp","image":"https://img1.doubanio.com/view/photo/l/public/p2559332018.webp","cover":"https://img1.doubanio.com/view/photo/sqs/public/p2559332018.webp","alt":"https://movie.douban.com/photos/photo/2559332018/","id":"2559332018","icon":"https://img1.doubanio.com/view/photo/s/public/p2559332018.webp"},{"thumb":"https://img1.doubanio.com/view/photo/m/public/p2567074307.webp","image":"https://img1.doubanio.com/view/photo/l/public/p2567074307.webp","cover":"https://img1.doubanio.com/view/photo/sqs/public/p2567074307.webp","alt":"https://movie.douban.com/photos/photo/2567074307/","id":"2567074307","icon":"https://img1.doubanio.com/view/photo/s/public/p2567074307.webp"},{"thumb":"https://img1.doubanio.com/view/photo/m/public/p2559327458.webp","image":"https://img1.doubanio.com/view/photo/l/public/p2559327458.webp","cover":"https://img1.doubanio.com/view/photo/sqs/public/p2559327458.webp","alt":"https://movie.douban.com/photos/photo/2559327458/","id":"2559327458","icon":"https://img1.doubanio.com/view/photo/s/public/p2559327458.webp"},{"thumb":"https://img3.doubanio.com/view/photo/m/public/p2548021472.webp","image":"https://img3.doubanio.com/view/photo/l/public/p2548021472.webp","cover":"https://img3.doubanio.com/view/photo/sqs/public/p2548021472.webp","alt":"https://movie.douban.com/photos/photo/2548021472/","id":"2548021472","icon":"https://img3.doubanio.com/view/photo/s/public/p2548021472.webp"},{"thumb":"https://img9.doubanio.com/view/photo/m/public/p2544890794.webp","image":"https://img9.doubanio.com/view/photo/l/public/p2544890794.webp","cover":"https://img9.doubanio.com/view/photo/sqs/public/p2544890794.webp","alt":"https://movie.douban.com/photos/photo/2544890794/","id":"2544890794","icon":"https://img9.doubanio.com/view/photo/s/public/p2544890794.webp"},{"thumb":"https://img1.doubanio.com/view/photo/m/public/p2523650089.webp","image":"https://img1.doubanio.com/view/photo/l/public/p2523650089.webp","cover":"https://img1.doubanio.com/view/photo/sqs/public/p2523650089.webp","alt":"https://movie.douban.com/photos/photo/2523650089/","id":"2523650089","icon":"https://img1.doubanio.com/view/photo/s/public/p2523650089.webp"},{"thumb":"https://img1.doubanio.com/view/photo/m/public/p2575352589.webp","image":"https://img1.doubanio.com/view/photo/l/public/p2575352589.webp","cover":"https://img1.doubanio.com/view/photo/sqs/public/p2575352589.webp","alt":"https://movie.douban.com/photos/photo/2575352589/","id":"2575352589","icon":"https://img1.doubanio.com/view/photo/s/public/p2575352589.webp"}]
     * summary : 2013年迪士尼《冰雪奇缘》续集。安娜、艾莎一伙人将深入神秘魔法森林，发现到艾伦戴尔王国长久以来深藏的秘密，一个有着风火水土元素的魔法国度，以及艾莎魔法来源的真相。
     * clips : [{"medium":"https://img3.doubanio.com/img/trailer/medium/2574683515.jpg?1574234827","title":"片段","subject_id":"25887288","alt":"https://movie.douban.com/trailer/255782/","small":"https://img3.doubanio.com/img/trailer/small/2574683515.jpg?1574234827","resource_url":"http://vt1.doubanio.com/201912031059/31b13508d082163c65ad26b44dd8b6a2/view/movie/M/302550782.mp4","id":"255782"},{"medium":"https://img1.doubanio.com/img/trailer/medium/2574627598.jpg?1574153866","title":"片段 (中文字幕)","subject_id":"25887288","alt":"https://movie.douban.com/trailer/255730/","small":"https://img1.doubanio.com/img/trailer/small/2574627598.jpg?1574153866","resource_url":"http://vt1.doubanio.com/201912031059/f04e40183ea132bdac81e8daebbf1247/view/movie/M/302550730.mp4","id":"255730"},{"medium":"https://img1.doubanio.com/img/trailer/medium/2574627799.jpg?1574153808","title":"片段 (中文字幕)","subject_id":"25887288","alt":"https://movie.douban.com/trailer/255733/","small":"https://img1.doubanio.com/img/trailer/small/2574627799.jpg?1574153808","resource_url":"http://vt1.doubanio.com/201912031059/ee5d60549876d3071d042b649d712816/view/movie/M/302550733.mp4","id":"255733"},{"medium":"https://img9.doubanio.com/img/trailer/medium/2574627866.jpg?1574153830","title":"片段 (中文字幕)","subject_id":"25887288","alt":"https://movie.douban.com/trailer/255734/","small":"https://img9.doubanio.com/img/trailer/small/2574627866.jpg?1574153830","resource_url":"http://vt1.doubanio.com/201912031059/1fa50ef21f5e6d16253bf502e33a015f/view/movie/M/302550734.mp4","id":"255734"}]
     * subtype : movie
     * directors : [{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48399.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48399.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48399.webp"},"name_en":"Chris Buck","name":"克里斯·巴克","alt":"https://movie.douban.com/celebrity/1279552/","id":"1279552"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392548591.79.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392548591.79.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392548591.79.webp"},"name_en":"Jennifer Lee","name":"珍妮弗·李","alt":"https://movie.douban.com/celebrity/1335174/","id":"1335174"}]
     * comments_count : 55825
     * popular_reviews : [{"rating":{"max":5,"value":4,"min":0},"title":"【多图】本片重要情节原型：北方人与大坝","subject_id":"25887288","author":{"uid":"xryutu","avatar":"https://img1.doubanio.com/icon/u3476889-18.jpg","signature":"","alt":"https://www.douban.com/people/xryutu/","id":"3476889","name":"祥瑞御兔"},"summary":"由于伟大的防火长城把维基墙了，国内观众可能无法轻易获得关于本片重要情节原型的信息。这里我把它整理总结了一下，供观众和对本片感兴趣的人参考。 首先，片中的北方人原住民（Northuldran）其原型不是印第安人...","alt":"https://movie.douban.com/review/12050012/","id":"12050012"},{"rating":{"max":5,"value":4,"min":0},"title":"迪士尼又一次陷入续集魔咒，拍不好动画续集的迪士尼","subject_id":"25887288","author":{"uid":"129169745","avatar":"https://img3.doubanio.com/icon/u129169745-3.jpg","signature":"","alt":"https://www.douban.com/people/129169745/","id":"129169745","name":"VictorZou"},"summary":"成功往往让我们忘记获得成功的动力来源\u2026\u2026我们没有义务创作艺术。我们没有义务发表声明。挣钱是我们的唯一目标\u2014\u2014迈克尔 艾斯纳，1981年，员工备忘录 7/10，推荐，顺便补充：\u201d远不如第一部\u201c。0点场，看完不能...","alt":"https://movie.douban.com/review/12045544/","id":"12045544"},{"rating":{"max":5,"value":5,"min":0},"title":"《冰雪奇缘2》：从成长到成熟","subject_id":"25887288","author":{"uid":"157887545","avatar":"https://img3.doubanio.com/icon/u157887545-3.jpg","signature":"码字工\u2026\u2026","alt":"https://www.douban.com/people/157887545/","id":"157887545","name":"陆冠均"},"summary":"【文末有二次更新】 我个人对《冰雪奇缘》非常有感情，2014年初在国内上映时，即便已经晚了国外几个月时间，我依然兴致勃勃地三刷了，影片制作无可挑剔，艾莎和安娜之间那份纯真而坚定的情谊更是给了我耳目一新的...","alt":"https://movie.douban.com/review/12029508/","id":"12029508"},{"rating":{"max":5,"value":5,"min":0},"title":"冰雪奇缘之第五元素 又名：我姐姐又跑了","subject_id":"25887288","author":{"uid":"nyzone","avatar":"https://img1.doubanio.com/icon/u41226838-28.jpg","signature":"","alt":"https://www.douban.com/people/nyzone/","id":"41226838","name":"江南"},"summary":"（含二刷二次修改，玩梗居多，欢迎各位冰学家一起来玩） 1、一刷后：歌真的不如第一部（邓布利多摇头   二刷后：Into the unknown~~~~~~~~~~~~~~ 2、olaf全场MVP 3、olaf：她平地起冰宫！她随手换衣服！  elsa：...","alt":"https://movie.douban.com/review/12047544/","id":"12047544"},{"rating":{"max":5,"value":5,"min":0},"title":"《冰雪奇缘2》，女神回归，女性归位，女性电影的新高度，绝对超越第一部的最好的续集电影。","subject_id":"25887288","author":{"uid":"207163381","avatar":"https://img3.doubanio.com/icon/u207163381-1.jpg","signature":"","alt":"https://www.douban.com/people/207163381/","id":"207163381","name":"xinshu"},"summary":"冰雪奇缘2的编剧是詹妮弗李，我看电影时最后等着看编导，就为看看编剧的名字是谁。我认为这个名字值得记住。第一部的时候我也没关注过编剧是谁导演是谁，第一部是一个很有活力的作品，也是一个相当简单的故事，我...","alt":"https://movie.douban.com/review/12051735/","id":"12051735"},{"rating":{"max":5,"value":3,"min":0},"title":"阿伦黛尔的地理问题。","subject_id":"25887288","author":{"uid":"45763604","avatar":"https://img1.doubanio.com/icon/user_normal.jpg","signature":"","alt":"https://www.douban.com/people/45763604/","id":"45763604","name":"yamadai"},"summary":"先补一句，百合无限好，保命。 依据影片地图，阿伦黛尔在于大陆板块的西面，海拔偏低，典型西海岸国家。而魔法国度在阿伦黛尔的北部，西海岸高海拔地区。 根据影片北部有强烈的潮汐反应，而南部河流平静。可以推...","alt":"https://movie.douban.com/review/12045724/","id":"12045724"},{"rating":{"max":5,"value":5,"min":0},"title":"立意极高，三观极正，政治隐喻，历史教育片--冰雪奇缘2","subject_id":"25887288","author":{"uid":"103949445","avatar":"https://img3.doubanio.com/icon/u103949445-2.jpg","signature":"","alt":"https://www.douban.com/people/103949445/","id":"103949445","name":"olnOnlo"},"summary":"个人认为冰雪奇缘2是一部政治隐喻片，极富教育意义。 其中事件、人物和各类意象都代表着现实历史的一部分，比如最主要的大坝。 破除大坝，就是在纠正历史错误，虽然迟到但永远不晚。 这过程中有像祖父那样颠倒黑...","alt":"https://movie.douban.com/review/12046512/","id":"12046512"},{"rating":{"max":5,"value":3,"min":0},"title":"六年磨一剑，感觉有点锈","subject_id":"25887288","author":{"uid":"49841982","avatar":"https://img9.doubanio.com/icon/u49841982-14.jpg","signature":"","alt":"https://www.douban.com/people/49841982/","id":"49841982","name":"舒心酱"},"summary":"三星半。 时隔六年之后，《冰雪奇缘》第二部终于登陆院线。 视觉特效优秀一如既往，然而故事非常淡薄、线索异常潦草，合家欢作品越发只剩下\u201c带儿童看热闹\u201d的属性。 一，惊艳感退却，平庸感延续 《冰雪奇缘2》最...","alt":"https://movie.douban.com/review/12046848/","id":"12046848"},{"rating":{"max":5,"value":4,"min":0},"title":"《冰雪奇缘2》幕后揭秘","subject_id":"25887288","author":{"uid":"129169745","avatar":"https://img3.doubanio.com/icon/u129169745-3.jpg","signature":"","alt":"https://www.douban.com/people/129169745/","id":"129169745","name":"VictorZou"},"summary":"电影上映三天了，关于《冰雪奇缘2》的各种讨论也比较火热，那么想必豆友们关于这部电影有不少疑问，这时，最好的参考资料就是《The Art of Frozen 2》和官方发布的幕后介绍视频了。我将整理这些资料，向大家揭示...","alt":"https://movie.douban.com/review/12053529/","id":"12053529"},{"rating":{"max":5,"value":3,"min":0},"title":"质量比不上前作，但仍然是一部带给我感动的作品","subject_id":"25887288","author":{"uid":"48369193","avatar":"https://img9.doubanio.com/icon/u48369193-16.jpg","signature":"","alt":"https://www.douban.com/people/48369193/","id":"48369193","name":"二十二岛主"},"summary":"本文首发于公众号：电影岛赏 （j_movie），欢迎关注。 作者： Grace天妮 经过六年的打磨，迪士尼推出了《冰雪奇缘2》。在《冰雪奇缘1》中，主人公艾莎和安娜已经完成了一次自我蜕变，我们看到艾莎克服了自己对于...","alt":"https://movie.douban.com/review/12046616/","id":"12046616"}]
     * ratings_count : 132581
     * aka : ["魔雪奇缘2(港)","Frozen 2"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String original_title;
    private int collect_count;
    private ImagesBean images;
    private String douban_site;
    private String year;
    private String alt;
    private String id;
    private String mobile_url;
    private int photos_count;
    private String pubdate;
    private String title;
    private Object do_count;
    private boolean has_video;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private String website;
    private boolean has_schedule;
    private Object collection;
    private Object episodes_count;
    private boolean has_ticket;
    private Object current_season;
    private String mainland_pubdate;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<?> videos;
    private List<String> blooper_urls;
    private List<PopularCommentsBean> popular_comments;
    private List<String> languages;
    private List<WritersBean> writers;
    private List<String> pubdates;
    private List<String> tags;
    private List<String> durations;
    private List<String> genres;
    private List<TrailersBean> trailers;
    private List<String> trailer_urls;
    private List<BloopersBean> bloopers;
    private List<String> clip_urls;
    private List<CastsBean> casts;
    private List<String> countries;
    private List<PhotosBean> photos;
    private List<ClipsBean> clips;
    private List<DirectorsBean> directors;
    private List<PopularReviewsBean> popular_reviews;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
        this.photos_count = photos_count;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isHas_schedule() {
        return has_schedule;
    }

    public void setHas_schedule(boolean has_schedule) {
        this.has_schedule = has_schedule;
    }

    public Object getCollection() {
        return collection;
    }

    public void setCollection(Object collection) {
        this.collection = collection;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public boolean isHas_ticket() {
        return has_ticket;
    }

    public void setHas_ticket(boolean has_ticket) {
        this.has_ticket = has_ticket;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<?> getVideos() {
        return videos;
    }

    public void setVideos(List<?> videos) {
        this.videos = videos;
    }

    public List<String> getBlooper_urls() {
        return blooper_urls;
    }

    public void setBlooper_urls(List<String> blooper_urls) {
        this.blooper_urls = blooper_urls;
    }

    public List<PopularCommentsBean> getPopular_comments() {
        return popular_comments;
    }

    public void setPopular_comments(List<PopularCommentsBean> popular_comments) {
        this.popular_comments = popular_comments;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<WritersBean> getWriters() {
        return writers;
    }

    public void setWriters(List<WritersBean> writers) {
        this.writers = writers;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<TrailersBean> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailersBean> trailers) {
        this.trailers = trailers;
    }

    public List<String> getTrailer_urls() {
        return trailer_urls;
    }

    public void setTrailer_urls(List<String> trailer_urls) {
        this.trailer_urls = trailer_urls;
    }

    public List<BloopersBean> getBloopers() {
        return bloopers;
    }

    public void setBloopers(List<BloopersBean> bloopers) {
        this.bloopers = bloopers;
    }

    public List<String> getClip_urls() {
        return clip_urls;
    }

    public void setClip_urls(List<String> clip_urls) {
        this.clip_urls = clip_urls;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public List<ClipsBean> getClips() {
        return clips;
    }

    public void setClips(List<ClipsBean> clips) {
        this.clips = clips;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<PopularReviewsBean> getPopular_reviews() {
        return popular_reviews;
    }

    public void setPopular_reviews(List<PopularReviewsBean> popular_reviews) {
        this.popular_reviews = popular_reviews;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 7.3
         * details : {"1":160,"3":9112,"2":1304,"5":3767,"4":8965}
         * stars : 40
         * min : 0
         */

        private int max;
        private double average;
        private DetailsBean details;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public DetailsBean getDetails() {
            return details;
        }

        public void setDetails(DetailsBean details) {
            this.details = details;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public static class DetailsBean {
            /**
             * 1 : 160.0
             * 3 : 9112.0
             * 2 : 1304.0
             * 5 : 3767.0
             * 4 : 8965.0
             */

            @SerializedName("1")
            private double _$1;
            @SerializedName("3")
            private double _$3;
            @SerializedName("2")
            private double _$2;
            @SerializedName("5")
            private double _$5;
            @SerializedName("4")
            private double _$4;

            public double get_$1() {
                return _$1;
            }

            public void set_$1(double _$1) {
                this._$1 = _$1;
            }

            public double get_$3() {
                return _$3;
            }

            public void set_$3(double _$3) {
                this._$3 = _$3;
            }

            public double get_$2() {
                return _$2;
            }

            public void set_$2(double _$2) {
                this._$2 = _$2;
            }

            public double get_$5() {
                return _$5;
            }

            public void set_$5(double _$5) {
                this._$5 = _$5;
            }

            public double get_$4() {
                return _$4;
            }

            public void set_$4(double _$4) {
                this._$4 = _$4;
            }
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2572847101.webp
         * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2572847101.webp
         * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2572847101.webp
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class PopularCommentsBean {
        /**
         * rating : {"max":5,"value":3,"min":0}
         * useful_count : 2651
         * author : {"uid":"lingrui1995","avatar":"https://img1.doubanio.com/icon/u63688511-18.jpg","signature":"一个影迷","alt":"https://www.douban.com/people/lingrui1995/","id":"63688511","name":"凌睿"}
         * subject_id : 25887288
         * content : 当皮克斯动画越来越有想象力的同时，没想到迪士尼动画已经变得如此平庸、吃老本、不求上进。
         的确技术更先进了，画面更精美了，但是内核和剧本却严重倒退，华而不实，形式大于内容。
         第一部中对女性力量的赞美、女性不应该被爱情和婚姻定义、不需要王子也能做公主、正视自己的独特之处而不在乎他人的看法……在第二部通通荡然无存，竟然变成了一部环保片。
         解决所有问题的办法，竟然是毁掉大坝。迪士尼动画什么时候变得这么说教了？
         又双叒叕是两个王国握手言和的大团圆结局，好像什么都没发生过一样。俗套得不能再俗套了，甚至上个月同属迪士尼的《沉睡魔咒2》刚刚才拍过。
         毫无悬念本片票房将大爆，因为它拍得太工整、太华丽了，没有任何问题。
         但是这种打安全牌的合家欢电影已经看得太多了，我还是怀念以前能看到各种风格、各种类型的电影的日子。
         * created_at : 2019-11-22 13:22:29
         * id : 2051209299
         */

        private RatingBeanX rating;
        private int useful_count;
        private AuthorBean author;
        private String subject_id;
        private String content;
        private String created_at;
        private String id;

        public RatingBeanX getRating() {
            return rating;
        }

        public void setRating(RatingBeanX rating) {
            this.rating = rating;
        }

        public int getUseful_count() {
            return useful_count;
        }

        public void setUseful_count(int useful_count) {
            this.useful_count = useful_count;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class RatingBeanX {
            /**
             * max : 5
             * value : 3.0
             * min : 0
             */

            private int max;
            private double value;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class AuthorBean {
            /**
             * uid : lingrui1995
             * avatar : https://img1.doubanio.com/icon/u63688511-18.jpg
             * signature : 一个影迷
             * alt : https://www.douban.com/people/lingrui1995/
             * id : 63688511
             * name : 凌睿
             */

            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class WritersBean {
        /**
         * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392548591.79.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392548591.79.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392548591.79.webp"}
         * name_en : Jennifer Lee
         * name : 珍妮弗·李
         * alt : https://movie.douban.com/celebrity/1335174/
         * id : 1335174
         */

        private AvatarsBean avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392548591.79.webp
             * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392548591.79.webp
             * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392548591.79.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class TrailersBean {
        /**
         * medium : https://img3.doubanio.com/img/trailer/medium/2569586491.jpg?
         * title : 中国预告片 (中文字幕)
         * subject_id : 25887288
         * alt : https://movie.douban.com/trailer/253176/
         * small : https://img3.doubanio.com/img/trailer/small/2569586491.jpg?
         * resource_url : http://vt1.doubanio.com/201912031059/2bf26411063ef0f5adbd38e8abef0157/view/movie/M/302530176.mp4
         * id : 253176
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class BloopersBean {
        /**
         * medium : https://img3.doubanio.com/img/trailer/medium/2574683481.jpg?1574234809
         * title : 花絮
         * subject_id : 25887288
         * alt : https://movie.douban.com/trailer/255780/
         * small : https://img3.doubanio.com/img/trailer/small/2574683481.jpg?1574234809
         * resource_url : http://vt1.doubanio.com/201912031059/787737cf1d41f904e615c45873da2984/view/movie/M/302550780.mp4
         * id : 255780
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class CastsBean {
        /**
         * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395152016.01.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395152016.01.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395152016.01.webp"}
         * name_en : Kristen Bell
         * name : 克里斯汀·贝尔
         * alt : https://movie.douban.com/celebrity/1031240/
         * id : 1031240
         */

        private AvatarsBeanX avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX {
            /**
             * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395152016.01.webp
             * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395152016.01.webp
             * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395152016.01.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class PhotosBean {
        /**
         * thumb : https://img1.doubanio.com/view/photo/m/public/p2569630078.webp
         * image : https://img1.doubanio.com/view/photo/l/public/p2569630078.webp
         * cover : https://img1.doubanio.com/view/photo/sqs/public/p2569630078.webp
         * alt : https://movie.douban.com/photos/photo/2569630078/
         * id : 2569630078
         * icon : https://img1.doubanio.com/view/photo/s/public/p2569630078.webp
         */

        private String thumb;
        private String image;
        private String cover;
        private String alt;
        private String id;
        private String icon;

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class ClipsBean {
        /**
         * medium : https://img3.doubanio.com/img/trailer/medium/2574683515.jpg?1574234827
         * title : 片段
         * subject_id : 25887288
         * alt : https://movie.douban.com/trailer/255782/
         * small : https://img3.doubanio.com/img/trailer/small/2574683515.jpg?1574234827
         * resource_url : http://vt1.doubanio.com/201912031059/31b13508d082163c65ad26b44dd8b6a2/view/movie/M/302550782.mp4
         * id : 255782
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class DirectorsBean {
        /**
         * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48399.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48399.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48399.webp"}
         * name_en : Chris Buck
         * name : 克里斯·巴克
         * alt : https://movie.douban.com/celebrity/1279552/
         * id : 1279552
         */

        private AvatarsBeanXX avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBeanXX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanXX avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanXX {
            /**
             * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48399.webp
             * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48399.webp
             * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48399.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class PopularReviewsBean {
        /**
         * rating : {"max":5,"value":4,"min":0}
         * title : 【多图】本片重要情节原型：北方人与大坝
         * subject_id : 25887288
         * author : {"uid":"xryutu","avatar":"https://img1.doubanio.com/icon/u3476889-18.jpg","signature":"","alt":"https://www.douban.com/people/xryutu/","id":"3476889","name":"祥瑞御兔"}
         * summary : 由于伟大的防火长城把维基墙了，国内观众可能无法轻易获得关于本片重要情节原型的信息。这里我把它整理总结了一下，供观众和对本片感兴趣的人参考。 首先，片中的北方人原住民（Northuldran）其原型不是印第安人...
         * alt : https://movie.douban.com/review/12050012/
         * id : 12050012
         */

        private RatingBeanXX rating;
        private String title;
        private String subject_id;
        private AuthorBeanX author;
        private String summary;
        private String alt;
        private String id;

        public RatingBeanXX getRating() {
            return rating;
        }

        public void setRating(RatingBeanXX rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public AuthorBeanX getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBeanX author) {
            this.author = author;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class RatingBeanXX {
            /**
             * max : 5
             * value : 4.0
             * min : 0
             */

            private int max;
            private double value;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class AuthorBeanX {
            /**
             * uid : xryutu
             * avatar : https://img1.doubanio.com/icon/u3476889-18.jpg
             * signature :
             * alt : https://www.douban.com/people/xryutu/
             * id : 3476889
             * name : 祥瑞御兔
             */

            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
