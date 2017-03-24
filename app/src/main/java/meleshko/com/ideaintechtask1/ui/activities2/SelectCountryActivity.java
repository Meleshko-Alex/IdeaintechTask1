package meleshko.com.ideaintechtask1.ui.activities2;

import android.os.Bundle;
import android.util.Log;

import com.google.i18n.phonenumbers.PhoneNumberUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.models.Country;

import static java.lang.String.valueOf;

public class SelectCountryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_country);

        setTitleActionBar(getString(R.string.select_country));

        getCountryList();

        /*PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        Set<String> set = phoneUtil.getSupportedRegions();
        String[] allContries = set.toArray(new String[set.size()]);

        String countryName;
        String countryShortName;
        String phoneCode;
        for (int i = 0; i < set.size(); i++) {
            countryShortName = allContries[i];
            phoneCode = "+" + valueOf(phoneUtil.getCountryCodeForRegion(countryShortName));
            //countryShortName = allContries[i].toLowerCase();
            Locale locale = new Locale("en", allContries[i]);
            countryName = locale.getDisplayCountry(new Locale("en"));

            Country country = new Country(countryName, countryShortName.toLowerCase(), phoneCode);
            //Log.d("AAA", country1 + " " + countryName + phoneUtil.getCountryCodeForRegion("RU"));
            Log.d("AAA", country.getName() + "  "  + country.getShortName() + "   " + country.getPhoneCode());*/

        }

    public void getCountryList(){
        String countryName;
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        Set<String> set = phoneUtil.getSupportedRegions();
        String[] allContriesShortNsmes = set.toArray(new String[set.size()]);
        String[] allContriesNames = new String[set.size()];
        String[] sortAllContriesNames = new String[set.size()];
        for(int i = 0; i < allContriesShortNsmes.length; i++){
            Locale locale = new Locale("en", allContriesShortNsmes[i]);
            allContriesNames[i]  = locale.getDisplayCountry(new Locale("en"));
            sortAllContriesNames[i]  = locale.getDisplayCountry(new Locale("en"));
        }
        Arrays.sort(sortAllContriesNames);
        List<Country> dataList = new ArrayList<>();
        for(int i = 0; i < allContriesNames.length; i++){
            dataList.add(new Country(
                    sortAllContriesNames[i],
                    "+" + valueOf(phoneUtil.getCountryCodeForRegion(allContriesShortNsmes[i])),
                     getFlagResID(allContriesShortNsmes[i].toLowerCase())));
        }

        for(Country country : dataList){
            Log.d("AAA", country.getName() + "  "  + country.getPhoneCode() + "   " + country.getFlagImageRes());
        }

    }

    static int getFlagResID(String country) {
        switch (country) {
            case "af": //afghanistan
                return R.drawable.af;
            case "al": //albania
                return R.drawable.al;
            case "dz": //algeria
                return R.drawable.dz;
            case "ad": //andorra
                return R.drawable.ad;
            case "ao": //angola
                return R.drawable.ao;
            case "aq": //antarctica // custom
                return R.drawable.aq;
            case "ar": //argentina
                return R.drawable.ar;
            case "am": //armenia
                return R.drawable.am;
            case "aw": //aruba
                return R.drawable.aw;
            case "au": //australia
                return R.drawable.au;
            case "at": //austria
                return R.drawable.at;
            case "az": //azerbaijan
                return R.drawable.az;
            case "bh": //bahrain
                return R.drawable.bh;
            case "bd": //bangladesh
                return R.drawable.bd;
            case "by": //belarus
                return R.drawable.by;
            case "be": //belgium
                return R.drawable.be;
            case "bz": //belize
                return R.drawable.bz;
            case "bj": //benin
                return R.drawable.bj;
            case "bt": //bhutan
                return R.drawable.bt;
            case "bo": //bolivia, plurinational state of
                return R.drawable.bo;
            case "ba": //bosnia and herzegovina
                return R.drawable.ba;
            case "bw": //botswana
                return R.drawable.bw;
            case "br": //brazil
                return R.drawable.br;
            case "bn": //brunei darussalam // custom
                return R.drawable.bn;
            case "bg": //bulgaria
                return R.drawable.bg;
            case "bf": //burkina faso
                return R.drawable.bf;
            case "mm": //myanmar
                return R.drawable.mm;
            case "bi": //burundi
                return R.drawable.bi;
            case "kh": //cambodia
                return R.drawable.kh;
            case "cm": //cameroon
                return R.drawable.cm;
            case "ca": //canada
                return R.drawable.ca;
            case "cv": //cape verde
                return R.drawable.cv;
            case "cf": //central african republic
                return R.drawable.cf;
            case "td": //chad
                return R.drawable.td;
            case "cl": //chile
                return R.drawable.cl;
            case "cn": //china
                return R.drawable.cn;
            case "cx": //christmas island
                return R.drawable.cx;
            case "cc": //cocos (keeling) islands
                return R.drawable.cc;// custom
            case "co": //colombia
                return R.drawable.co;
            case "km": //comoros
                return R.drawable.km;
            case "cg": //congo
                return R.drawable.cg;
            case "cd": //congo, the democratic republic of the
                return R.drawable.cd;
            case "ck": //cook islands
                return R.drawable.ck;
            case "cr": //costa rica
                return R.drawable.cr;
            case "hr": //croatia
                return R.drawable.hr;
            case "cu": //cuba
                return R.drawable.cu;
            case "cy": //cyprus
                return R.drawable.cy;
            case "cz": //czech republic
                return R.drawable.cz;
            case "dk": //denmark
                return R.drawable.dk;
            case "dj": //djibouti
                return R.drawable.dj;
            case "tl": //timor-leste
                return R.drawable.tl;
            case "ec": //ecuador
                return R.drawable.ec;
            case "eg": //egypt
                return R.drawable.eg;
            case "sv": //el salvador
                return R.drawable.sv;
            case "gq": //equatorial guinea
                return R.drawable.gq;
            case "er": //eritrea
                return R.drawable.er;
            case "ee": //estonia
                return R.drawable.ee;
            case "et": //ethiopia
                return R.drawable.et;
            case "fk": //falkland islands (malvinas)
                return R.drawable.fk;
            case "fo": //faroe islands
                return R.drawable.fo;
            case "fj": //fiji
                return R.drawable.fj;
            case "fi": //finland
                return R.drawable.fi;
            case "fr": //france
                return R.drawable.fr;
            case "pf": //french polynesia
                return R.drawable.pf;
            case "ga": //gabon
                return R.drawable.ga;
            case "gm": //gambia
                return R.drawable.gm;
            case "ge": //georgia
                return R.drawable.ge;
            case "de": //germany
                return R.drawable.de;
            case "gh": //ghana
                return R.drawable.gh;
            case "gi": //gibraltar
                return R.drawable.gi;
            case "gr": //greece
                return R.drawable.gr;
            case "gl": //greenland
                return R.drawable.gl;
            case "gt": //guatemala
                return R.drawable.gt;
            case "gn": //guinea
                return R.drawable.gn;
            case "gw": //guinea-bissau
                return R.drawable.gw;
            case "gy": //guyana
                return R.drawable.gy;
            case "ht": //haiti
                return R.drawable.ht;
            case "hn": //honduras
                return R.drawable.hn;
            case "hk": //hong kong
                return R.drawable.hk;
            case "hu": //hungary
                return R.drawable.hu;
            case "in": //india
                return R.drawable.in;
            case "id": //indonesia
                return R.drawable.id;
            case "ir": //iran, islamic republic of
                return R.drawable.ir;
            case "iq": //iraq
                return R.drawable.iq;
            case "ie": //ireland
                return R.drawable.ie;
            case "im": //isle of man
                return R.drawable.im; // custom
            case "il": //israel
                return R.drawable.il;
            case "it": //italy
                return R.drawable.it;
            case "ci": //côte d\'ivoire
                return R.drawable.ci;
            case "jp": //japan
                return R.drawable.jp;
            case "jo": //jordan
                return R.drawable.jo;
            case "kz": //kazakhstan
                return R.drawable.kz;
            case "ke": //kenya
                return R.drawable.ke;
            case "ki": //kiribati
                return R.drawable.ki;
            case "kw": //kuwait
                return R.drawable.kw;
            case "kg": //kyrgyzstan
                return R.drawable.kg;
            case "la": //lao people\'s democratic republic
                return R.drawable.la;
            case "lv": //latvia
                return R.drawable.lv;
            case "lb": //lebanon
                return R.drawable.lb;
            case "ls": //lesotho
                return R.drawable.ls;
            case "lr": //liberia
                return R.drawable.lr;
            case "ly": //libya
                return R.drawable.ly;
            case "li": //liechtenstein
                return R.drawable.li;
            case "lt": //lithuania
                return R.drawable.lt;
            case "lu": //luxembourg
                return R.drawable.lu;
            case "mo": //macao
                return R.drawable.mo;
            case "mk": //macedonia, the former yugoslav republic of
                return R.drawable.mk;
            case "mg": //madagascar
                return R.drawable.mg;
            case "mw": //malawi
                return R.drawable.mw;
            case "my": //malaysia
                return R.drawable.my;
            case "mv": //maldives
                return R.drawable.mv;
            case "ml": //mali
                return R.drawable.ml;
            case "mt": //malta
                return R.drawable.mt;
            case "mh": //marshall islands
                return R.drawable.mh;
            case "mr": //mauritania
                return R.drawable.mr;
            case "mu": //mauritius
                return R.drawable.mu;
            case "yt": //mayotte
                return R.drawable.nof; // no exact flag found
            case "mx": //mexico
                return R.drawable.mx;
            case "fm": //micronesia, federated states of
                return R.drawable.fm;
            case "md": //moldova, republic of
                return R.drawable.md;
            case "mc": //monaco
                return R.drawable.mc;
            case "mn": //mongolia
                return R.drawable.mn;
            case "me": //montenegro
                return R.drawable.me;// custom
            case "ma": //morocco
                return R.drawable.ma;
            case "mz": //mozambique
                return R.drawable.mz;
            case "na": //namibia
                return R.drawable.na;
            case "nr": //nauru
                return R.drawable.nr;
            case "np": //nepal
                return R.drawable.np;
            case "nl": //netherlands
                return R.drawable.nl;
            case "nc": //new caledonia
                return R.drawable.nc;// custom
            case "nz": //new zealand
                return R.drawable.nz;
            case "ni": //nicaragua
                return R.drawable.ni;
            case "ne": //niger
                return R.drawable.ne;
            case "ng": //nigeria
                return R.drawable.ng;
            case "nu": //niue
                return R.drawable.nu;
            case "kp": //north korea
                return R.drawable.kp;
            case "no": //norway
                return R.drawable.no;
            case "om": //oman
                return R.drawable.om;
            case "pk": //pakistan
                return R.drawable.pk;
            case "pw": //palau
                return R.drawable.pw;
            case "pa": //panama
                return R.drawable.pa;
            case "pg": //papua new guinea
                return R.drawable.pg;
            case "py": //paraguay
                return R.drawable.py;
            case "pe": //peru
                return R.drawable.pe;
            case "ph": //philippines
                return R.drawable.ph;
            case "pn": //pitcairn
                return R.drawable.pn;
            case "pl": //poland
                return R.drawable.pl;
            case "pt": //portugal
                return R.drawable.pt;
            case "pr": //puerto rico
                return R.drawable.pr;
            case "qa": //qatar
                return R.drawable.qa;
            case "ro": //romania
                return R.drawable.ro;
            case "ru": //russian federation
                return R.drawable.ru;
            case "rw": //rwanda
                return R.drawable.rw;
            case "bl": //saint barthélemy
                return R.drawable.bl;// custom
            case "ws": //samoa
                return R.drawable.ws;
            case "sm": //san marino
                return R.drawable.sm;
            case "st": //sao tome and principe
                return R.drawable.st;
            case "sa": //saudi arabia
                return R.drawable.sa;
            case "sn": //senegal
                return R.drawable.sn;
            case "rs": //serbia
                return R.drawable.rs; // custom
            case "sc": //seychelles
                return R.drawable.sc;
            case "sl": //sierra leone
                return R.drawable.sl;
            case "sg": //singapore
                return R.drawable.sg;
            case "sk": //slovakia
                return R.drawable.sk;
            case "si": //slovenia
                return R.drawable.si;
            case "sb": //solomon islands
                return R.drawable.sb;
            case "so": //somalia
                return R.drawable.so;
            case "za": //south africa
                return R.drawable.za;
            case "kr": //south korea
                return R.drawable.kr;
            case "es": //spain
                return R.drawable.es;
            case "lk": //sri lanka
                return R.drawable.lk;
            case "sh": //saint helena, ascension and tristan da cunha
                return R.drawable.sh; // custom
            case "pm": //saint pierre and miquelon
                return R.drawable.nof;
            case "sd": //sudan
                return R.drawable.sd;
            case "sr": //suriname
                return R.drawable.sr;
            case "sz": //swaziland
                return R.drawable.sz;
            case "se": //sweden
                return R.drawable.se;
            case "ch": //switzerland
                return R.drawable.ch;
            case "sy": //syrian arab republic
                return R.drawable.sy;
            case "tw": //taiwan, province of china
                return R.drawable.tw;
            case "tj": //tajikistan
                return R.drawable.tj;
            case "tz": //tanzania, united republic of
                return R.drawable.tz;
            case "th": //thailand
                return R.drawable.th;
            case "tg": //togo
                return R.drawable.tg;
            case "tk": //tokelau
                return R.drawable.tk; // custom
            case "to": //tonga
                return R.drawable.to;
            case "tn": //tunisia
                return R.drawable.tn;
            case "tr": //turkey
                return R.drawable.tr;
            case "tm": //turkmenistan
                return R.drawable.tm;
            case "tv": //tuvalu
                return R.drawable.tv;
            case "ae": //united arab emirates
                return R.drawable.ae;
            case "ug": //uganda
                return R.drawable.ug;
            case "gb": //united kingdom
                return R.drawable.gb;
            case "ua": //ukraine
                return R.drawable.ua;
            case "uy": //uruguay
                return R.drawable.uy;
            case "us": //united states
                return R.drawable.us;
            case "uz": //uzbekistan
                return R.drawable.uz;
            case "vu": //vanuatu
                return R.drawable.vu;
            case "va": //holy see (vatican city state)
                return R.drawable.va;
            case "ve": //venezuela, bolivarian republic of
                return R.drawable.ve;
            case "vn": //vietnam
                return R.drawable.vn;
            case "wf": //wallis and futuna
                return R.drawable.wff;
            case "ye": //yemen
                return R.drawable.ye;
            case "zm": //zambia
                return R.drawable.zm;
            case "zw": //zimbabwe
                return R.drawable.zw;

            // Caribbean Islands
            case "ai": //anguilla
                return R.drawable.ai;
            case "ag": //antigua & barbuda
                return R.drawable.ag;
            case "bs": //bahamas
                return R.drawable.bs;
            case "bb": //barbados
                return R.drawable.bb;
            case "bm": //bermuda
                return R.drawable.bm;
            case "vg": //british virgin islands
                return R.drawable.vg;
            case "dm": //dominica
                return R.drawable.dm;
            case "do": //dominican republic
                return R.drawable.doo;
            case "gd": //grenada
                return R.drawable.gd;
            case "jm": //jamaica
                return R.drawable.jm;
            case "ms": //montserrat
                return R.drawable.ms;
            case "kn": //st kitts & nevis
                return R.drawable.kn;
            case "lc": //st lucia
                return R.drawable.lc;
            case "vc": //st vincent & the grenadines
                return R.drawable.vc;
            case "tt": //trinidad & tobago
                return R.drawable.tt;
            case "tc": //turks & caicos islands
                return R.drawable.tc;
            case "vi": //us virgin islands
                return R.drawable.vi;
            default:
                return R.drawable.nof;
        }
    }
}
