package me.zhyd.oauth.enums.scope;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 微信公众平台 OAuth 授权范围
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum AuthWechatMpScope implements AuthScope {
    /**
     * {@code scope} 含义，以{@code description} 为准
     */
    SNSAPI_USERINFO("snsapi_userinfo", "弹出授权页面，可通过openid拿到昵称、性别、所在地。并且， 即使在未关注的情况下，只要用户授权，也能获取其信息", true),
    SNSAPI_BASE("snsapi_base", "不弹出授权页面，直接跳转，只能获取用户openid", false);

    private String scope;
    private String description;
    private boolean isDefault;

    public static List<AuthScope> getDefaultScopes() {
        AuthWechatMpScope[] scopes = AuthWechatMpScope.values();
        List<AuthScope> defaultScopes = new ArrayList<>();
        for (AuthWechatMpScope scope : scopes) {
            if (scope.isDefault()) {
                defaultScopes.add(scope);
            }
        }
        return defaultScopes;
    }

    public static List<String> listScope() {
        return Arrays.stream(AuthWechatMpScope.values()).map(AuthWechatMpScope::getScope).collect(Collectors.toList());
    }
}
