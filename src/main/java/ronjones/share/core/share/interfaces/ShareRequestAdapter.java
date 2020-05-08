package ronjones.share.core.share.interfaces;

import ronjones.share.core.share.ShareRequest;

public interface ShareRequestAdapter<K> {

    K convert(ShareRequest shareRequest);
}
