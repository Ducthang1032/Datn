package com.poly.datn.be.constants;

public interface CommonConstant {
    String SOURCE_FILE = "sourceFile";
    String TEMP_FILE = "tempFile";
    String TARGET_FILE = "targetFile";
    String AUTHORIZATION = "Authorization";
    String BEARER = "Bearer ";
    String IMAGE = "image";
    String MESSAGE = "message";
    boolean MULTIPART = true;
    String UTF8_ENCODING = "utf-8";
    String MESSAGE_TYPE = "text/html";
    String IMAGE_PREFIX = "image_";
    String THUMBNAIL_PREFIX = "thumbnail_";
    String GIF_IMAGE_TYPE = "gif";
    String PNG_IMAGE_TYPE = "png";
    String VIDEO_PREFIX = "video_";
    String FILE_PREFIX = "file_";
    String UNDERSCORE = "_";
    String COLON = ":";
    String ASTERISK = "*";
    String AT_SIGN = "@";
    String QUESTION_MARK = "?";
    String SLASH = "/";
    String CONTENT_TYPE = "application/json";
    String CHARSET_UTF_8 = "UTF-8";
    String CONTENT_TYPE_KEY = "Content-Type";
    String CONTENT_LENGTH_KEY = "Content-Length";
    String CONTENT_DISPOSITION_KEY = "Content-Disposition";
    String TOPIC_CACHE_KEY_NAME = "cache_all_topic_object";
    String MODULE_PERMISSION_CACHE_KEY_NAME = "cache_all_module_permission_object";
    String ROLE_KEY_NAME = "cache_all_role_object";
    String LANGUAGE_CACHE_KEY_NAME = "cache_all_language_object";
    String MAPPING_LIST_TIER_KEY = "mapping_list_tier_key";
    String MAPPING_USER_KEY = "mapping_user_key";
    String SYSTEM_SETTING_KEY = "term_and_privacy";
    String KEY_CONFIG_CORE = "key_config_core";
    Integer PAGE_NUMBER_DEFAULT = 0;
    Integer PAGE_SIZE_DEFAULT = 20;
    String REPORT_CACHE_KEY_NAME = "cache_all_report_object";
    boolean IS_POST_IN_GROUP = true;
    int ONE_DAY_AGO = 1;
    int THREE_DAY_AGO = 4;
    int SIX_DAY_AGO = 7;
    String USER_ID_ATTRIBUTE = "currentUserId";
    String DEVICE_ID_ATTRIBUTE = "currentDeviceId";
    String ROLE_ATTRIBUTE = "currentRole";
    String SUB_SYSTEM_ATTRIBUTE = "currentSubSystem";
    String DUMMY_POEM_CAN_ACCESS_FORMAT = "%s_%s";//include HTTP Method and uri
    String AUTHENTICATE_WITH_P3TOKEN_FORMAT = "%s_%s";//include HTTP Method and uri
    String POST_URI = "/posts/";
    String GROUP_URI = "/groups/";
    String GROUP_ID_IN_URI = "{group_id}";
    String POST_ID_IN_URI = "{post_id}";
    String RESOURCE_ID_IN_URI = "{resource_id}";
    String COMMENT_ID_IN_URI = "{comment_id}";
    String GROUP_ID_PARAM = "group_id";
    String POST_ID_PARAM = "post_id";
    String RESOURCE_ID_PARAM = "resource_id";
    String COMMENT_ID_PARAM = "comment_id";
    String DISPLAY_NAME = "displayName";
    String CREATE_DATE = "create_date";
    String CQ_USER_SETTING_KEY = "cqusersetting:";
    String CQ_USER_EXIST_KEY = "cquserexist:";
    String FCM_TOKEN_KEY = "fcmtoken:";
    String POEM3_TOKEN_KEY = "poem3token:";
    String POEM3_TOKEN_PUSH_NOTI_KEY = "poem3tokenpushnoti:";
    String ACCESS_TOKEN_KEY = "accesstoken:";
    String LEARNING_ADMIN_TOKEN_KEY = "learningadmintoken";
    String LEARNING_USER_TOKEN_KEY = "learningusertoken:";
    String USER_LAST_ACTIVE_AT_KEY = "userlastactiveatkey:";
    String USER_LAST_VIEW_AT_KEY = "userlastviewatkey:";
    String ADMIN_ACCESS_TOKEN_KEY = "adminaccesstoken:";
    String REFRESH_TOKEN_KEY = "refreshtoken:";
    String SPHOTON_CHAT_TOKEN_KEY = "sphotonchattoken:";
    String SPHOTON_CHAT_ID = "sphotonchatId:";
    String REDIS_CONFIRM_PASSWORD_KEY = "confirmPassword:";
    String CQ_USER_STATUS_KEY = "cquserstatus:";
    String NOT_CONFIRM = "false";
    String CONFIRMED = "true";
    String GROUP_MEM_RIGHTS_CACHE_KEY_NAME = "cache_all_group_rights_object";
    String DEFAULT_SEARCH_PEOPLE_TYPE = "all";
    String SUB_SYSTEM = "sub_system";
    String USER_ID = "user_id";
    String DEVICE_ID = "device_id";
    String ROLE = "role";
    String HEADER_USER_ID = "User-Id";
    String HEADER_DEVICE_ID = "Device-Id";
    String CONTENT_NOTI = "content";
    String SCORE = "score";
    String ALL = "all";
    String ADMIN_INFO_KEY_NAME = "admin_info_key_name";
    String ACTOR_NAME = "{actor_name}";
    String USER_NAME = "{user_name}";
    String ROLE_NAME = "{role_name}";
    String POST_OWNER = "{post_owner}";
    String GROUP_NAME = "{group_name}";
    String REASON_NAME = "{reason_name}";
    String OLD_GROUP_NAME = "{old_group_name}";
    String NEW_GROUP_NAME = "{new_group_name}";
    String PROJECT_NAME = "CQ Station";
    String AUTH_KEY_CDN = "?auth_key=";
    String CQ_CHECK_PASSWORD_FAIL = "cqcheckpasswordfail:";
    String CQ_SPAM_REQUEST = "cqspamrequest:";
    String FIND_POST_IN_TEAM = "in:";
    String FIND_POST_FROM_USER = "from:";
    String FLAGGED_POST = "flagged_post";
    String GMT = "GMT%s";
    String FALSE_STR = "false";
    String TRUE_STR = "true";
    String DOUBLE_UNDERLINE = "__";
    String NEWEST_FIRST = "Newest first";
    String MOST_REPORTED_FIRST = "Most reported first";
    String CHANEL_DISPLAY_NAME = "{chanel_display_name}";
    String CQ_TIMEOUT_CHAT_NOTI = "cqtimeoutchatnoti:";
    String CQ_CHECK_SPAM_NOTIFICATION = "checkSpamNotification:";
    String MESSAGE_CONTENT = "{message_content}";
    String YOU = "you";
    String DEFAULT = "default";
    String YOUR = "your";
    String GROUP_DISPLAY_NAME = "{group_display_name}";
    String REACT_EMOJI_NAME = "{react_emoji_name}";
    String REGEX_MENTION = "((\\[\\[)(\\[.*?])(]]))";
    Integer POSITION_JSON_MENTION = 3;
    Integer POSITION_MENTION = 1;
    String LINK_PREVIEW_TAG_CONTENT = "content";
    String LINK_PREVIEW_GET_PROPERTY = "meta[property=%s]";
    String LINK_PREVIEW_GET_NAME = "meta[name=%s]";
    String REDIS_CONFIRM_QR_CODE_KEY = "confirmQRCode:";
    String DICTIONARY_PATH = "cqsta-common/src/main/java/com/tdt/cqsta/common/censored/profanity_list.txt";
    String MESSAGES_PATH = "classpath:messages";
    String REDIS_ADD_POINT = "addPoint:";
    String LINK_PREVIEW_GET_TAG_IMG = "img";
    String LINK_PREVIEW_GET_URL_IMG = "src";
    String AGENT = "Mozilla";
    String REFERRER = "http://www.google.com";
    String POST_ID_IN_URL = "postId";
    String GROUP_ID_IN_URL = "groupId";
    Integer MAX_PAGE_SIZE_LMS = 60;
    String START_TIME_GATEWAY_REQUEST = "start-time-gateway-request";
    String REQUEST_ID = "request-id";
    String TIME_REQUEST = "time-request";
    String IFRAME = "iframe";
    String REPLACEMENT_FILE_NAME_IN_CONTENT_DISPOSITION = "$1";
    String CONTENT_DISPOSITION_INLINE = "inline; filename=\"%s\"";
    String CONTENT_DISPOSITION_ATTACHMENT = "attachment; filename=\"%s\"";
    String MANAGER_VOUCHER_EXPORT_PDF_FILE_NAME = "Manager_voucher_%s.pdf";
    String MANAGER_VOUCHER_PDF_TEMPLATE_PATH = "template/manager_voucher.jrxml";
    String CQ_LOGO_PATH = "template/cqlogo.png";
    String STR_TRUE = "true";
    String OTHERS_REPORT = "Others";
}
