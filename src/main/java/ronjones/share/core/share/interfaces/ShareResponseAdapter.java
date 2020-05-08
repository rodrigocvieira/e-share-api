package ronjones.share.core.share.interfaces;

import ronjones.share.core.share.ShareResponse;

public interface ShareResponseAdapter<K> {

    ShareResponse convert(K request);
}
