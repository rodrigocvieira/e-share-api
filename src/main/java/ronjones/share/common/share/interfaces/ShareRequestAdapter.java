package ronjones.share.common.share.interfaces;

import ronjones.share.common.share.ShareRequest;

public interface ShareRequestAdapter<K> {

    K convert(ShareRequest shareRequest);
}
