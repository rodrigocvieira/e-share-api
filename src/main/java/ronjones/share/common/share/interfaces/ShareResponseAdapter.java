package ronjones.share.common.share.interfaces;

import ronjones.share.common.share.ShareResponse;

public interface ShareResponseAdapter<K> {

    ShareResponse convert(K request);
}
