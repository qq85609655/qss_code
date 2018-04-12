package com.fr.hailian.util;

import java.util.HashMap;
import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

/***
 * 新分词软件
 * @author Tom
 *
 */
public class HanlpUtil {
	
	public static HashMap<String, String> doSplitWords(String msg){
		HashMap<String, String> result = new HashMap<String, String>();
		List<String> keywordList = HanLP.extractKeyword(msg, 5);
		String str = "";
		for(int i = 0 ; i < keywordList.size() ; i ++){
			//判断是否存在标签元素
			if(keywordList.get(i).indexOf("p>",0)==-1){
				str += keywordList.get(i)+"#";
			}
		}
		result.put("keyWords", str);
		List<Term> termList = StandardTokenizer.segment(msg);
		result.put("words", termList.toString());
		return result;
	}
	public static void main(String[] args){
		//List<Term> termList = StandardTokenizer.segment("商品和服务");
		//System.out.println(termList);
		//String words = "<p>摘要：山东省31家；河南省17家；贵州省5家；甘肃省3；陕西省21；江西省6家；浙江省8家；海南省6家；四川省12家；内蒙古1家。正值开展清理整顿各类交易场所“回头看”活动近一年之际，笔者坐下来冷静回忆了交易场所在“回头看”前后展现出来的众生相，顿生怅惘。是为何故？且看从“回头看”开展到今，行业从恐惧到平静再到大胆的角色变化。“回头看”伊始，行业内风声鹤唳，停业、跑路、抓人、转型等讯息就像冬日的阳光，刺得笔者张不开眼睛，也不愿意多看。不是说不敢正视，只是笔者认为，“回头看”开展以来，那些啃噬行业公信力的龌鼠（违法违规的交易场所），关门大吉甚好，抓进去吃几年牢饭，想必业内业外皆双手鼓掌支持。正义不会缺席，这是他们应得的，无需关注。正所谓“东风夜放花千树。更吹落、星如雨。宝马雕车香满路。凤箫声动，玉壶光转，一夜鱼龙舞。”于是乎，一场“回头看”让大多数交易场所都变成了“孕妇”——反应剧烈，小心慎行。行业可谓是黄昏庭院柳啼鸦，繁华流逝。在“五停止”（停止开新户、停止开新仓、停止上市新品种、停止增会员、停止业务宣传）背景下，行业内掀起了一轮“下线潮”，纷纷停止运营，拥护监管，保壳过关。处理客诉让大多数交易场所应接不暇，焦头烂额，不过这都是静悄悄进行的，就连之前多么风光的媒体报道等讯息也被删的精光。当然，也有不甘寂寞的，玩起了“商城模式”、“零售模式”、“网红直播”等新奇玩法，至于这些新玩法的本质，大家不言自明。笔者也了解到，老百姓也早已看穿了这一切，警惕起来，这些转型的平台俨然举步维艰。伴随着多个省份相继祭出的交易场所“黑名单”，行业气氛紧张到了极点，都在“咬耳根”式的互探风声，不敢大声喧哗。那时的行业静得可怕，就像是进入了图书馆后，开启的静音模式，却又不知道看什么书，更是无心看书。行情乐观情绪的转机应是6月30日的到来，这是一个振奋行业的日子。在这一天，山东省金融办在其官网发布了一则“关于已经通过检查验收的交易场所名单”的通告，率先公布出了27家“白名单”（花儿街注：加上烟台、日照单独公布的各2家，山东省共有31家“白名单”平台）。随后，多个省份相继祭出各自辖内的“白名单”（见后文）。捷报频传，行业也活跃了起来，有的交易场所也开始大张旗鼓干了起来，看来是真的“卧薪尝胆”了。这时，行业的聚光灯也自然地打到了这些上榜“白名单”的交易场所上。大家都想知道，有“白名单”背书的交易场所接下来该怎么走路，带来的是什么模式，能不能学习复制。随后，笔者便“学习琢磨”了几家换血的“白名单”交易场所。可笔者发现，有的依旧走赚快钱的老路，玩着涉嫌聚众赌博的老把戏，只不过加了个商品环节，艺术化了一下，俨然就成了促进商品流通的“好孩子”。另有一类，你不让我玩，我让别人玩，做起了外包。而那些承包的操盘团队也是赚快钱心态，这家平台不行了，我换家继续承包，现在的”白名单“的交易场所这么多，一个平台干个一年，甚至几个月就可以赚个盆满钵满了。听到这么儿戏的话，笔者咬得牙根疼。除此之外，还有的平台，确实是走了货物，还给国家交了税，你说这还不是服务实体经济嘛，可这些平台却是把招募会员的“入场费”通过眼花缭乱的“走帐”转换成为“贸易收入”，为的是应对司法机关的一旦介入。如此这般，你说，这模式真的是在服务实体么？那么，清整活动的开展进行过多次了，也有些年头了，为啥就会踏进同一条河流？这个行业提心吊胆过日子何时是个头？之所以这样，是什么原因呢？利益驱使？背景深厚？在理想面前，恐怕这些问号都会显得不堪一击。试问，还记得交易场所插上金融翅膀的初心么？在夺取国际大宗商品定价权的最好时刻，非要为了图一时之快，去背负上历史罪人的骂名么？这些满不在乎，被骂也就被骂了，“我”爽了就行的群体。行业真是被股恶臭之气压的喘不过来，也怪不得别人鄙夷的目光了。更可气的是行业被做的优秀的平台要与之为伍，真叫人可气又无奈。也真要为这些优秀的平台叫好，出淤泥而不染，让人心生敬畏。但也要为真实踏实去做事的起步平台感叹惋惜，因为清整活动而暂停金融工具的使用，暂时封冻了金融属性。有力使不出来的感觉，想必都懂。同时，也要为你们的大义凛然点赞，你们没有说什么，只是说了句：“清理整顿是行业的好事情，这些平台早该整了，我们大力支持。”等类似的话。未来，应还有更多的“白名单”交易场所被公布。之所以被业界称为“白名单”，笔者所见：“应是一张白纸，重新开始，续写蓝图。”在此，望与同业人士一起，一起学习、交流，为实现大宗梦，共努力。（以上转自大宗传媒，作者：史乐蒙）附1：山东省“白名单”平台（31家）a.介于现货与期货之间的大宗商品交易场所（10家） 齐鲁农产品交易中心 山东休斯顿石油装备交易中心 华东石油交易中心 山东广丰橡胶轮胎交易中心 东营新华福岛能源交易中心 东亚畜牧现货产品交易所 国商商品交易中心 威海国际海洋商品交易中心 日照大宗商品交易中心 临沂国际商品交易中心b.开展权益类交易业务的交易场所（17家） 齐鲁股权交易中心 山东产权交易中心 山东泰山文化艺术品交易所 山东文化产权交易所 山东省能源环境交易中心 山东金融资产交易中心 济南产权交易中心 青岛大数据交易中心 山东黄河三角洲产权交易中心 烟台海洋产权交易中心 烟台联合产权交易中心 齐鲁农村产权交易中心 山东潍坊产权交易中心 寿光果菜品种权交易中心 潍坊文化产权交易中心 山东蓝色经济区产权交易中心 菏泽市兴菏国有产权交易有限责任公司此外，山东烟台保留鼎丰商品电子交易市场、栖霞苹果电子交易市场2家现货交易场所；山东日照市保留山东金文电子商务有限公司（原日照日月明电子商务有限公司）、山东海倍电子商务股份有限公司2家大宗商品现货交易场所。附2：河南省“白名单”平台（17家，先公布“白名单”，后公布“黑名单”） 河南省技术产权交易所 河南省产权交易中心 河南中原产权交易有限公司 中原股权交易中心 中原金融资产交易中心 洛阳市产权交易中心 南阳产权交易中心 许昌亚太产权交易中心 信阳市申资产权交易中心 平顶山市国土资源交易中心 濮阳市华宇产权交易有限公司 安阳市产权交易中心 郑州棉花交易市场 郑州肉类商品交易所 中京商品交易市场 驻马店市天元芝麻批发市场有限公司 河南亚太有色金融物流园有限公司附3：贵州省“白名单”平台（5家，均尚未开展实际业务） 贵州中进大宗商品交易中心 贵州黔中生态茶交易中心 中航南方煤炭交易中心 贵州茶资源交易中心 贵州酱香酒交易中心附4：甘肃省“白名单”平台（3家，暂无商品现货类） 甘肃股权交易中心 甘肃文交所 甘肃省产权交易所附5：陕西省“白名单”平台（21家，邮币卡平台全军覆没）a.商品类7家 陕西煤炭交易中心 陕西能源化工交易所 西安环海陆港商品交易中心 大商道商品交易市场 中大（延安）商品交易中心 钛谷有色金属交易中心 西安大宗农产品交易所b.权益类14家 陕西文化产权交易所 陕西书画艺术品交易中心 西部产权交易所 陕西股权交易中心 陕西环境权交易所 陕西气候交易中心 西安股权托管交易中心 西安文化产权交易中心 西安技术产权交易有限公司 西安百金互联网金融资产交易中心 西安合众互联网金融资产交易中心 恒大金融资产交易中心（西安）有限公司 西安丝路金融资产交易中心 互联网金融资产（西咸新区）交易中心附6：江西省“白名单”平台（6家，不确定是不是最终版） 江西省产权交易所 江西联合股权交易中心 南方林业产权交易所 江西赣南金融资产交易中心 抚州市海峡交易所 中江国际商品交易中心随后，据公众号“上饶金融”发布文章透露，江西省交易场所清整活动已结束，但总体验收还未完成，因此上述6家网传“白名单”不确定是不是最终版。附7：浙江省“白名单”平台（8家）金融类1家：浙江股权交易中心商品类2家：浙江东海商品交易中心、绍兴黄酒原酒电子商务平台文化类3家：浙江文化艺术品交易所、杭州文化产权交易所、浙江圆音海收藏艺术品交易中心其他类2家：浙江知识产权交易中心、浙江大数据交易中心附8：海南省“白名单”平台（6家） 海南产权交易所 海南大宗商品交易中心 海南股权交易中心 海南国际商品交易中心 洋浦国际能源交易中心 亚联盟金融资产交易中心附9：四川省“白名单”平台（12家） 天府（四川）联合产权交易中心 西南联合产权交易所 天府商品交易所 四川联合环境交易所 四川金融资产交易所 成都农村产权交易所 四川中国白酒产品交易中心 成都花木交易所 蒙顶山茶叶交易所 成都文化产权交易所 四川联合酒类交易所 成都托管中心值得注意的是，四川联合酒类交易所、蒙顶山茶叶交易所、成都文化产权交易所是“附条件通过”。附10：内蒙古“白名单”平台（1家）9月21日，包头稀土产品交易所发布公告称，接到内蒙古自治区商务厅下发的《关于进一步规范稀土现货经营的通知》，准许稀交所继续开展正常的经营工作，这标志着稀交所已顺利通过内蒙古自治区各类交易场所排查整治专项活动验收。（来源：花儿街、大宗传媒）欢迎投稿:QQ：739012056。微信：qq739012056免责声明：猪头社尊重各方版权 如有版权异议请联系本号处理。</p>";
		String words = "<p></p><p></p><p> 点击上方</p><p> “乾坤基金”</p><p>可以订阅哦！</p><p> </p><p></p><p> </p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p> 关注</p><p> 1、央行：2017年社会融资规模增量累计为19.44万亿元，比上年多1.63万亿元。2017年社会融资规模存量为174.64万亿元，同比增长12%。2017年12月末，M2余额167.68万亿元，同比增长8.2%。全年人民币贷款增加13.53万亿元，同比多增8782亿元。</p><p> 2、中金公司：银行在年末一定程度上压缩了贷款投放、同业投资以及债券投资。其中贷款和同业投资的压缩导致所派生的存款也明显低于去年同期，是引发M2下滑的主因。预计年初的贷款、社融和M2会有一定的恢复。</p><p> 3、海关总署：2017年，我国货物贸易进出口总值27.79万亿元，同比增长14.2%。其中，出口15.33万亿元，增长10.8%；进口12.46万亿元，增长18.7%；贸易顺差2.87万亿元，收窄14.2%。</p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> 一、宏观经济</p><p> 1、经济日报：国有重点大型企业监事会认为，各中央企业认真贯彻党中央、国务院决策部署，发展质量和效益稳步提升，利润增速创近5年同期最好水平，经营效益稳中向好趋势更加巩固。</p><p> 2、上证报：国务院督查地方国企改革。分析人士指出，国企改革的重心正不断下移，改革的力度比以前要大许多，且具体目标非常务实，方案、措施都具有可操作性。因此，也确保了改革的可执行、可量化、可考核、可问责。</p><p> 3、经济参考报：业内人士表示，2018年金融体系去杠杆将进一步推进，监管规范和制度完善的重点仍然是遏制金融空转、堵住影子银行风险口子等，并进一步夯实去年政策的基础，防止违规业务死灰复燃。</p><p> 二、地产聚焦</p><p> 1、中国经济网：2017年12月末，人民币房地产贷款余额32.25万亿元，同比增长20.9%，增速比上年末回落6.1个百分点。其中，个人住房贷款余额21.86万亿元，同比增长22.2%，增速比上年末回落14.5个百分点。</p><p> 2、北京日报：北京市政府办公厅印发《北京市人民政府关于加快科技创新构建高精尖经济结构用地政策的意见》。北京将在19个重点区域中启动“弹性年期出让土地和土地年租制”，除了极特殊情况，土地流转年限缩短到20年以内。</p><p> 3、新华社：2018年起，南昌全面实行商品房屋租赁属地管理，市房屋租赁管理服务中心将定期发布房屋租赁指导价格与房屋租赁信息，让租客心里有本“明白账”。</p><p> 三、股市盘点</p><p> 1、上证指数报3428.94点，上涨0.11%，成交额2159.61亿。深证成指报11461.99点，下跌0.02%，成交额2452.78亿。创业板指报1785.71点，下跌1.03%，成交额578.37亿。两市合计成交4612.39亿。从盘面上看，房地产、贵金属等板块涨幅居前。</p><p> 2、恒生指数涨0.94%，报31412.54点。国企指数涨1.41%，报12468.93点。沪股通净流入15.92亿元，当日余额114.08亿元。深股通净流入6.93亿元，当日余额123.07亿元。</p><p> 3、证监会：2016年以来，新三板企业申请IPO数量增多，部分企业出现涉及“三类股东”的情况。监管部门在发审时进行了重点关注，部分企业也对“三类股东”进行了主动清理。要求公司控股股东、实控人、第一大股东不能是“三类股东”。</p><p> 4、上交所：与中国结算发布《股票质押式回购交易及登记结算业务办法（2018年修订）》，并自3月12日起正式实施。业务办法明确融入方不得为金融机构或其发行的产品，融入资金应当用于实体经济生产经营并专户管理。</p><p> 5、中证报：近日多家信托公司收紧股票配资业务，包括暂停新增有中间级的配资业务、暂停新增单票配资业务。业内人士指出，上述举措实质上是下调了目前股票信托的配资杠杆比例。</p><p> 6、证监会：1月12日，核准3家IPO批文。其中，上交所1家，中小板1家，创业板1家。上述企业筹资总额不超过62亿元。</p><p> 四、行业观察</p><p> 1、工商总局等27部门：发布《关于开展放心消费创建活动营造安全放心消费环境的指导意见》。提出到2020年，通过开展放心消费创建活动，努力营造安全放心的消费环境，消费纠纷解决渠道进一步畅通。</p><p> 2、银监会：具备一定条件的商业银行，可以新设或者选择1家已设立的村镇银行作为村镇银行的投资管理行，即投资管理型村镇银行，由其受让主发起人已持有的全部村镇银行股权，对所投资的村镇银行履行主发起人职责。</p><p> 3、央视新闻：外资企业万豪酒店集团在其会员邮件和APP注册页面将港澳台地区和西藏都列为了“国家”，此事件引起各界高度关注。外交部表示，我们欢迎外国企业来华投资兴业，同时在华经营的外国公司也应当尊重中国的主权和领土完整，遵守中国的法律，尊重中国人民的民族感情。</p><p> 4、上证报：从农药工业协会一位高层处获悉，农药行业核发排污许可证的大限就在最近两个月内，这之后将开展执法检查。未来，没有拿到证的企业将被要求停产，农药行业格局已进入一轮重大变化前的倒计时。</p><p> 五、产业数据</p><p> 1、新华网：2017年12月，内蒙古主产区动力煤坑口平均结算价格先涨后降，均价为213.83元／吨，环比略涨0.01%，同比上涨6.46%。同期，内蒙古电煤平均购进价格为206.29元／吨，环比下降2.54%，同比上涨6.43%，涨幅下降9.62个百分点。</p><p> 2、华印纸箱：1月10日－11日，全国54家造纸厂的最新废纸收购价中51家纸厂上调了废纸价格，幅度在30－150元／吨。在前期，随着废纸政策的调整，市场上废纸价格出现一定波动，有一定的降幅，而这几天，废纸价格又出现上扬趋势。</p><p> 3、证券时报：全球电阻第一大厂国巨上调电阻价格的消息不胫而走。此次调价主要是因为汇率持续升值、原物料及人工成本的持续上涨，价格上调幅度为15%至20%。去年内存（DRAM）价格每季度涨幅都超过20%，被动元器件中的电容更是收获了4－5倍的涨幅。</p><p> 六、公司要闻</p><p> 1、证券时报：近期，全国各地陆续进入流感高发期。上市药企的业务情况备受投资者关注。香雪制药表示，市场上对治疗流感的药物需求量持续增加；一品红表示，最近全国较多地方出现了流行病毒，其中儿童感染较多，公司相关产品销量也有相应提升。</p><p> 2、工信部：1月11日，针对近期媒体报道相关手机应用软件存在侵犯用户个人隐私的问题，工信部信息通信管理局约谈了百度、今日头条等三家企业。三家企业表示，今后将进一步规范用户个人信息收集使用行为。</p><p> 3、证券时报：茅台集团董事长袁仁国称，基于形势判断，茅台提出2018年发展目标是实现含税收入900亿元。另外，春节将至，茅台计划投放不少于7000吨茅台酒、6000吨系列酒，确保春节以前的投放量。</p><p> 七、资本动态</p><p> 1、国债期货震荡收涨，10年期国债期货主力合约T1803涨0.17%，5年期主力合约TF1803涨0.10%。10年期国债利率下跌2.09BP，至3.93%；10年期国开债利率下跌2.02BP，至5%。</p><p> 2、截至1月12日下午收盘，商品多数下跌，黑色系走弱。锰硅上涨2.07%，PVC、郑棉、橡胶涨逾1%，乙烯上涨1%，而跌幅方面，铁矿石下跌2.07%，沪镍、螺纹钢、苹果、焦煤、热卷、棕榈油、菜粕跌逾1%。</p><p> 3、在岸人民币兑美元16:30收盘，报6.468，涨0.627%，人民币中间价报6.4932，涨0.33%。NDF：3月报6.532，6个月报6.5665，1年报6.632，2年报6.758。</p><p> 4、新三板：1月12日合计挂牌11623家公司，当日新增0家，成交金额13.65亿，其中做市转让1.38亿，协议转让12.27亿。</p><p> 八、国际资讯</p><p> 1、美国：12月核心CPI环比0.3%，增速创1月份来新高，预期0.2%；12月核心CPI同比1.8%，预期1.7%。这强化了美联储2018年3月再次加息的预期，也有助于增强美联储官员对通胀回升的信心。</p><p> 2、波罗的海干散货指数：跌1.84%，报1279点，三连跌。</p><p> 3、标普500指数收涨18.68点，涨幅0.67%，报2786.24点。道琼斯工业平均指数收涨228.46点，涨幅0.89%，报25803.19点。纳斯达克综合指数收涨49.29点，涨幅0.68%，报7261.06点。美国三大股指2018年第六次齐创收盘纪录新高，得益于零售销售和大型银行财报双双向好。</p><p> 5、日经225跌0.24%，报23653.82点。韩国KOSPI指数涨0.34%，报2496.42点。</p><p> </p><p> </p><p> 信息来源：财经早餐</p><p> 信息整合：乾坤基金</p><p> </p><p> </p><p></p><p></p><p></p><p></p><p></p><p></p><p> </p><p> </p><p> </p><p></p><p></p><p> </p><p> </p><p> </p><p></p><p></p><p></p><p> －长按关注－</p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p> </p><p></p>";
		HashMap<String, String> map = doSplitWords(words);
		System.out.println(map.get("keyWords"));
		System.out.println(map.get("words"));
	}

}
