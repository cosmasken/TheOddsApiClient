package com.harambeeapps.theoddsapiclient.api;

import com.harambeeapps.theoddsapiclient.constants.AppConstant;

/**
 * Created by 2ndgengod on 9/28/2020.
 */

class HttpParams {
    //GET SPORTS
    public static final String ALLSPORTS ="v3/sports";

    //base link
    public static final String ALLODDS ="v3/odds/";
    //GET EPL ODDS
    public static final String GETODDSUKH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_epl}&region={uk}&mkt={h2h}";
    public static final String GETODDSUKSPREADS ="v3/odds/?apiKey={apiKey}&sport={soccer_epl}&region={uk}&mkt={spreads}";
    public static final String GETODDSUKTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_epl}&region={uk}&mkt={totals}";


    //NCAAF
    public static final String GETNCAAFH2H ="v3/odds/?apiKey={apiKey}&sport={americanfootball_ncaaf}&region={us}&mkt={h2h}";
    public static final String GETNCAAFSPREADS="v3/odds/?apiKey={apiKey}&sport={americanfootball_ncaaf}&region={us}&mkt={spreads}";
    public static final String GETNCAAFTOTALS ="v3/odds/?apiKey={apiKey}&sport={americanfootball_ncaaf}&region={us}&mkt={totals}";

    //NFL
    public static final String GETNFLH2H ="v3/odds/?apiKey={apiKey}&sport={americanfootball_nfl}&region={us}&mkt={h2h}";
    public static final String GETNFLSPREADS="v3/odds/?apiKey={apiKey}&sport={americanfootball_nfl}&region={us}&mkt={spreads}";
    public static final String GETNFLTOTALS ="v3/odds/?apiKey={apiKey}&sport={americanfootball_nfl}&region={us}&mkt={totals}";

    //AFL
    public static final String GETAFLH2H ="v3/odds/?apiKey={apiKey}&sport={aussierules_afl}&region={au}&mkt={h2h}";
    public static final String GETAFLSPREADS="v3/odds/?apiKey={apiKey}&sport={aussierules_afl}&region={au}&mkt={spreads}";
    public static final String GETAFLTOTALS ="v3/odds/?apiKey={apiKey}&sport={aussierules_afl}&region={au}&mkt={totals}";

    //MLB
    public static final String GETMLBH2H ="v3/odds/?apiKey={apiKey}&sport={baseball_mlb}&region={us}&mkt={h2h}";
    public static final String GETMLBSPREADS="v3/odds/?apiKey={apiKey}&sport={baseball_mlb}&region={us}&mkt={spreads}";
    public static final String GETMLBTOTALS ="v3/odds/?apiKey={apiKey}&sport={baseball_mlb}&region={us}&mkt={totals}";

    //Test Matches
    public static final String GETTESTMATCHESH2H ="v3/odds/?apiKey={apiKey}&sport={cricket_test_match}&region={au}&mkt={h2h}";
    public static final String GETTESTMATCHESSPREADS="v3/odds/?apiKey={apiKey}&sport={cricket_test_match}&region={au}&mkt={spreads}";
    public static final String GETTESTMATCHESTOTALS ="v3/odds/?apiKey={apiKey}&sport={cricket_test_match}&region={au}&mkt={totals}";

    //MMA
    public static final String GETMMAH2H ="v3/odds/?apiKey={apiKey}&sport={mma_mixed_martial_arts}&region={us}&mkt={h2h}";
    public static final String GETMMASPREADS="v3/odds/?apiKey={apiKey}&sport={mma_mixed_martial_arts}&region={us}&mkt={spreads}";
    public static final String GETMMATOTALS ="v3/odds/?apiKey={apiKey}&sport={mma_mixed_martial_arts}&region={us}&mkt={totals}";

    //NRL
    public static final String GETNRLH2H ="v3/odds/?apiKey={apiKey}&sport={rugbyleague_nrl}&region={au}&mkt={h2h}";
    public static final String GETNRLSPREADS="v3/odds/?apiKey={apiKey}&sport={rugbyleague_nrl}&region={au}&mkt={spreads}";
    public static final String GETNRLTOTALS ="v3/odds/?apiKey={apiKey}&sport={rugbyleague_nrl}&region={au}&mkt={totals}";

    //Belgium First Div"
    public static final String GETBELGIUMH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_belgium_first_div}&region={eu}&mkt={h2h}";
    public static final String GETBELGIUMPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_belgium_first_div}&region={eu}&mkt={spreads}";
    public static final String GETBELGIUMTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_belgium_first_div}&region={eu}&mkt={totals}";

    //Super League - China
    public static final String GETCHINAH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_china_superleague}&region={au}&mkt={h2h}";
    public static final String GETCHINASPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_china_superleague}&region={au}&mkt={spreads}";
    public static final String GETCHINATOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_china_superleague}&region={au}&mkt={totals}";

    //Denmark Superliga
    public static final String GETDENMARKSUPERLIGAH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_denmark_superliga}&region={eu}&mkt={h2h}";
    public static final String GETDENMARKSUPERLIGASPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_denmark_superliga}&region={eu}&mkt={spreads}";
    public static final String GETDENMARKSUPERLIGATOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_denmark_superliga}&region={eu}&mkt={totals}";

    //Championship
    public static final String GETCHAMPIONSHIPH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_efl_champ}&region={uk}&mkt={h2h}";
    public static final String GETCHAMPIONSHIPSPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_efl_champ}&region={uk}&mkt={spreads}";
    public static final String GETCHAMPIONSHIPTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_efl_champ}&region={uk}&mkt={totals}";

    //Eng League 1
    public static final String GETLEAGUE1SH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_england_league1}&region={uk}&mkt={h2h}";
    public static final String GETLEAGUE1SPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_england_league1}&region={uk}&mkt={spreads}";
    public static final String GETLEAGUE1TOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_england_league1}&region={uk}&mkt={totals}";

    //Eng League 2
    public static final String GETLEAGUE2H2H ="v3/odds/?apiKey={apiKey}&sport={soccer_england_league2}&region={uk}&mkt={h2h}";
    public static final String GETLEAGUE2SPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_england_league2}&region={uk}&mkt={spreads}";
    public static final String GETLEAGUE2TOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_england_league2}&region={uk}&mkt={totals}";
    //EPL
    public static final String GETEPLSH2H ="v3/odds/";
    public static final String GETEPLSPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_epl}&region={uk}&mkt={spreads}";
    public static final String GETEPLSTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_epl}&region={uk}&mkt={totals}";
    // Veikkausliiga - Finland
    public static final String GETFINLANDSH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_finland_veikkausliiga}&region={eu}&mkt={h2h}";
    public static final String GETFINLANDSPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_finland_veikkausliiga}&region={eu}&mkt={spreads}";
    public static final String GETFINLANDSTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_finland_veikkausliiga}&region={eu}&mkt={totals}";

    //Ligue 1 - France
    public static final String GETLIGUE1H2H ="v3/odds/?apiKey={apiKey}&sport={soccer_france_ligue_one}&region={eu}&mkt={h2h}";
    public static final String GETLIGUE1SPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_france_ligue_one}&region={eu}&mkt={spreads}";
    public static final String GETLIGUE1TOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_france_ligue_one}&region={eu}&mkt={totals}";

    //Ligue 2 - France
    public static final String GETLIGUE2SH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_france_ligue_two}&region={eu}&mkt={h2h}";
    public static final String GETLIGUE2SPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_france_ligue_two}&region={eu}&mkt={spreads}";
    public static final String GETLIGUE2TOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_france_ligue_two}&region={eu}&mkt={totals}";

    //Bundesliga - Germany
    public static final String GETBUNDESLIGASH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_germany_bundesliga}&region={eu}&mkt={h2h}";
    public static final String GETBUNDESLIGASPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_germany_bundesliga}&region={eu}&mkt={spreads}";
    public static final String GETBUNDESLIGATOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_germany_bundesliga}&region={eu}&mkt={totals}";

    //Bundesliga 2 - Germany
    public static final String GETBUNDESLIGA2H2H ="v3/odds/?apiKey={apiKey}&sport={soccer_germany_bundesliga2}&region={eu}&mkt={h2h}";
    public static final String GETBUNDESLIGA2SPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_germany_bundesliga2}&region={eu}&mkt={spreads}";
    public static final String GETBUNDESLIGA2TOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_germany_bundesliga2}&region={eu}&mkt={totals}";

    //Liga MX
    public static final String GETLIGAMXSH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_mexico_ligamx}&region={us}&mkt={h2h}";
    public static final String GETLIGAMXSPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_mexico_ligamx}&region={us}&mkt={spreads}";
    public static final String GETLIGAMXSTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_mexico_ligamx}&region={us}&mkt={totals}";

    //Dutch Eredivisie
    public static final String GETDUTCHSH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_netherlands_eredivisie}&region={eu}&mkt={h2h}";
    public static final String GETDUTCHSPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_netherlands_eredivisie}&region={eu}&mkt={spreads}";
    public static final String GETDUTCHSTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_netherlands_eredivisie}&region={eu}&mkt={totals}";

    //Eliteserien - Norway
    public static final String GETNORWAYH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_norway_eliteserien}&region={eu}&mkt={h2h}";
    public static final String GETNORWAYSPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_norway_eliteserien}&region={eu}&mkt={spreads}";
    public static final String GETNORWAYTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_norway_eliteserien}&region={eu}&mkt={totals}";

    //Primeira Liga - Portugal
    public static final String GETPORTUGALSH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_portugal_primeira_liga}&region={eu}&mkt={h2h}";
    public static final String GETPORTUGALPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_portugal_primeira_liga}&region={eu}&mkt={spreads}";
    public static final String GETPORTUGALTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_portugal_primeira_liga}&region={eu}&mkt={totals}";

    //Premier League - Russia
    public static final String GETRUSSIAH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_russia_premier_league}&region={eu}&mkt={h2h}";
    public static final String GETRUSSIASPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_russia_premier_league}&region={eu}&mkt={spreads}";
    public static final String GETRUSSIATOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_russia_premier_league}&region={eu}&mkt={totals}";

    //La Liga - Spain
    public static final String GETSPAINH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_spain_la_liga}&region={uk}&mkt={h2h}";
    public static final String GETSPAINSPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_spain_la_liga}&region={uk}&mkt={spreads}";
    public static final String GETSPAINTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_spain_la_liga}&region={uk}&mkt={totals}";

    //SPL
    public static final String GETSPLSH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_spl}&region={uk}&mkt={h2h}";
    public static final String GETSPLSPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_spl}&region={uk}&mkt={spreads}";
    public static final String GETSPLSTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_spl}&region={uk}&mkt={totals}";

    //Allsvenskan - Sweden
    public static final String GETSWEDENALLSVENKANH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_sweden_allsvenskan}&region={eu}&mkt={h2h}";
    public static final String GETSWEDENALLSVENKANSPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_sweden_allsvenskan}&region={eu}&mkt={spreads}";
    public static final String GETSWEDENALLSVENKANTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_sweden_allsvenskan}&region={eu}&mkt={totals}";

    //Superettan - Sweden
    public static final String GETSWEDENSUPERETTANH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_sweden_superettan}&region={eu}&mkt={h2h}";
    public static final String GETSWEDENSUPERETTANPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_sweden_superettan}&region={eu}&mkt={spreads}";
    public static final String GETSWEDENSUPERETTANTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_sweden_superettan}&region={eu}&mkt={totals}";

    //Super League - Swiss
    public static final String GETSWISSSH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_switzerland_superleague}&region={eu}&mkt={h2h}";
    public static final String GETSWISSSPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_switzerland_superleague}&region={eu}&mkt={spreads}";
    public static final String GETSWISSSTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_switzerland_superleague}&region={eu}&mkt={totals}";

    //MLS
    public static final String GETMLSH2H ="v3/odds/?apiKey={apiKey}&sport={soccer_usa_mls}&region={us}&mkt={h2h}";
    public static final String GETMLSSPREADS="v3/odds/?apiKey={apiKey}&sport={soccer_usa_mls}&region={us}&mkt={spreads}";
    public static final String GETMLSTOTALS ="v3/odds/?apiKey={apiKey}&sport={soccer_usa_mls}&region={us}&mkt={totals}";



}
